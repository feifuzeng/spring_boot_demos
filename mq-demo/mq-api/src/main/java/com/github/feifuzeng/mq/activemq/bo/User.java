package com.github.feifuzeng.mq.activemq.bo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 用户测试类
 * @Date 2019/1/4 15:52
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String username;

    private String password;

    private String gender;

    private Integer age;

}
