package com.github.feifuzeng.style.java.thread;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 线程池相关工具类
 * @createTime 2019年05月27日 16:54:00
 */
@Component
public class ThreadPoolUtil {

    /**
     * 线程池
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public ThreadPoolExecutorFactoryBean threadPoolExecutorFactoryBean() {
        ThreadPoolExecutorFactoryBean threadPoolExecutorFactoryBean = BeanUtils.instantiateClass(ThreadPoolExecutorFactoryBean.class);
        threadPoolExecutorFactoryBean.setCorePoolSize(2);
        threadPoolExecutorFactoryBean.setMaxPoolSize(Runtime.getRuntime().availableProcessors()*2 + 1);
        return threadPoolExecutorFactoryBean;
    }
}
