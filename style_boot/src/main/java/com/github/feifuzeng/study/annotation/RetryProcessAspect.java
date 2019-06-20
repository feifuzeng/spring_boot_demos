package com.github.feifuzeng.study.annotation;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 重试注解切面
 * @createTime 2019年06月20日 14:07:00
 */

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
@Log4j2
public class RetryProcessAspect {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @AfterThrowing(pointcut=("@annotation(com.github.feifuzeng.study.annotation.RetryProcess)"))
    public void tryAgain(JoinPoint point) {
        try {
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            RetryProcess retryProcess = methodSignature.getMethod().getAnnotation(RetryProcess.class);

            if (atomicInteger.intValue() < retryProcess.value()) {
                int i = atomicInteger.incrementAndGet();
                Thread.sleep(retryProcess.sleep() * i);
                log.debug("开始重试第" + i + "次");
                MethodInvocationProceedingJoinPoint methodPoint = ((MethodInvocationProceedingJoinPoint) point);
                methodPoint.proceed();
            }
        } catch (Throwable throwable) {
            tryAgain(point);
        }
    }
}
