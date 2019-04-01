package com.ohaotian.feifz.dubbo.service;

import com.ohaotian.feifz.dubbo.bo.User;

import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 16:31
 * @Version: 1.0
 * @Description: 用户相关接口
 */
public interface UserService {

    /**
     * 查询全量用户信息
     * @return
     */
    public User queryUser();
}
