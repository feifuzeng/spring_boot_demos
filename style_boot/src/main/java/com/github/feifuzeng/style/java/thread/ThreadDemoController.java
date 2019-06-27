package com.github.feifuzeng.style.java.thread;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 线程池相关-服务层
 * @createTime 2019年05月27日 16:57:00
 */
@Controller
@Log4j2
public class ThreadDemoController {

    @Resource
    private ThreadDemoService threadDemoService;

    @RequestMapping("/thread/test")
    @ResponseBody
    public String run(){
        log.info(Thread.currentThread().getId());
        threadDemoService.run();
        return "successful";
    }


}
