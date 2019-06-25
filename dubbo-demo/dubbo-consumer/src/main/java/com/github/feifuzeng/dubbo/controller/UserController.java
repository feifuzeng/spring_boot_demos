package com.github.feifuzeng.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.feifuzeng.dubbo.bo.User;
import com.github.feifuzeng.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: feifz
 * @Date: 2019-04-01 16:55
 * @Version: 1.0
 * @Description:
 */
@Controller
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/get")
    @ResponseBody
    public User get() {
        return userService.queryUser();
    }

}
