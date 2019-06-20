package com.github.feifuzeng.study.thread;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 线程池相关-服务层
 * @createTime 2019年05月27日 16:57:00
 */
@Service
@Log4j2
public class ThreadDemoService {
//
//    @Autowired
//    private ExecutorService executorService;


    /**
     * 具体业务方法
     */
    public void run(){
        test();
        String param = "xixi";
//        executorService.submit(()->execute(param));

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info(Thread.currentThread().getId());
                log.info("输入的参数为：{}",param);
            }
        });
        log.info("ddddd");
    }

    private void test(){
        log.info("执行普通业务逻辑方法");
    }


    /**
     * 需要放到线程池执行的方法
     */
//    private void execute(String param){
//
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        cachedThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                log.info(Thread.currentThread().getId());
//                log.info("输入的参数为：{}",param);
//            }
//        });
//    }
}
