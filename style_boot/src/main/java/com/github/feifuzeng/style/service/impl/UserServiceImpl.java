package com.github.feifuzeng.style.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.feifuzeng.style.spring.annotation.RetryProcess;
import com.github.feifuzeng.style.dao.UserMapper;
import com.github.feifuzeng.style.model.po.User;
import com.github.feifuzeng.style.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 15:10
 * @Version: 1.0
 * @Description: 用户相关实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    @RetryProcess(value = 2,sleep = 2000)
    public List<User> findList() {
        return userMapper.queryUserList();
    }


}
