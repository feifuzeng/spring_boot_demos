package com.github.feifuzeng.multidb.service.impl;

import com.github.feifuzeng.multidb.dao.primary.UserMapper;
import com.github.feifuzeng.multidb.dao.second.UserInfoMapper;
import com.github.feifuzeng.multidb.dao.primary.po.PrimaryUser;
import com.github.feifuzeng.multidb.dao.second.po.SecondUser;
import com.github.feifuzeng.multidb.service.UserService;


import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/28 15:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<PrimaryUser> getListdbone() {
        return userMapper.getList();
    }

    @Override
    public void addPrimary(PrimaryUser primaryUser) {

    }

    @Override
    public List<SecondUser> getListdbtwo() {
        return userInfoMapper.getList();
    }
}
