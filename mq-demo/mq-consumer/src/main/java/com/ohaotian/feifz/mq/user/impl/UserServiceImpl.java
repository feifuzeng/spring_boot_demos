package com.ohaotian.feifz.mq.user.impl;

import com.alibaba.fastjson.JSON;
import com.ohaotian.feifz.mq.activemq.bo.User;
import com.ohaotian.feifz.mq.user.UserService;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;


/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/7 10:41
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user){
//    log.info("增加用户信息入参======>>>>>"+ JSON.toJSONString(user));
    }
}
