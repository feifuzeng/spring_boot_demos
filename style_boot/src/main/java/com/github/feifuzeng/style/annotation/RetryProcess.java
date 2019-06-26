package com.github.feifuzeng.style.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 重试机制自定义注解
 * @createTime 2019年06月20日 14:05:00
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RetryProcess {
    int value() default 1;

    int sleep() default 1000;
}