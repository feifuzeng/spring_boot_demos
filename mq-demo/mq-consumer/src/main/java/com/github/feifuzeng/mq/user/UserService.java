package com.github.feifuzeng.mq.user;

import com.github.feifuzeng.mq.activemq.bo.User;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/7 10:40
 */
public interface UserService {

    /**
     * 增加用户信息
     * @param user
     * @throws Exception
     */
    public void addUser(User user);
}
