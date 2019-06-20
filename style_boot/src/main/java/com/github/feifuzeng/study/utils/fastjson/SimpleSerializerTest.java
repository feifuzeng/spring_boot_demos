package com.github.feifuzeng.study.utils.fastjson;

/**
 * @author feifz
 * @version 1.0.0
 * @Description fastjson简单使用
 * @createTime 2019年06月10日 16:37:00
 */

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class SimpleSerializerTest {

    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    public static void serialize() {
        User user = new User();
        user.setId(11L);
        user.setName("西安");
        user.setSex(false);
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user, true);
        System.out.println(jsonString);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\",\"sex\":\"男\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getSex());
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
    }
}