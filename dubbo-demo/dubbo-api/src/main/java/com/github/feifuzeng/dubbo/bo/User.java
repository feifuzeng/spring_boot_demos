package com.github.feifuzeng.dubbo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: feifz
 * @Date: 2019-04-01 16:29
 * @Version: 1.0
 * @Description: 用户基类
 */
@Data
public class User implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private String age;

    public User(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
