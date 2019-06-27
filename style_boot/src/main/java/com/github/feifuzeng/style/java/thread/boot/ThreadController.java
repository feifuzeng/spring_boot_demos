package com.github.feifuzeng.style.java.thread.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 测试springboot下 线程池测试类控制器
 * @createTime 2019年05月28日 17:16:00
 */
@Controller
@RequestMapping("/boot/thread")
public class ThreadController {

    @Resource
    private ThreadService threadService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        //调用service层的任务
        threadService.executeAsync();
        return "OK";
    }
}
