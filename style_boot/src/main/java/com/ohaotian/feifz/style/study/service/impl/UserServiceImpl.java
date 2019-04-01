package com.ohaotian.feifz.style.study.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ohaotian.feifz.style.study.dao.UserMapper;
import com.ohaotian.feifz.style.study.model.po.User;
import com.ohaotian.feifz.style.study.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 15:10
 * @Version: 1.0
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findList() {
        return userMapper.queryUserList();
    }

    ;
}
