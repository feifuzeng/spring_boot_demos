package com.github.feifuzeng.style.service;

import com.github.feifuzeng.style.model.po.User;

import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 15:10
 * @Version: 1.0
 * @Description: 用户相关接口定义
 */
public interface UserService {

    public List<User> findList();

}
