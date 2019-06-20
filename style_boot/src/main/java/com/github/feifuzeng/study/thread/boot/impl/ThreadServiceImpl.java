package com.github.feifuzeng.study.thread.boot.impl;

import com.github.feifuzeng.study.thread.boot.ThreadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 服务实现
 * @createTime 2019年05月28日 17:17:00
 */
@Service
@Log4j2
public class ThreadServiceImpl implements ThreadService {

    @Async("taskExecutor")
    @Override
    public void executeAsync() {
        log.info("start executeAsync");
        try {
            System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}
