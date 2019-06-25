package com.github.feifuzeng.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.feifuzeng.dubbo.bo.User;
import com.github.feifuzeng.dubbo.service.UserService;


/**
 * @Author: feifz
 * @Date: 2019-04-01 16:33
 * @Version: 1.0
 * @Description: 用户相关实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User queryUser() {
        User user = new User(1,"张三","18");
        return user;
    }
}
