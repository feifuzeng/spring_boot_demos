package com.ohaotian.feifz.style.study.lambdas;

import lombok.Data;

import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 测试基本类
 * @createTime 2019年04月16日 14:07:00
 */
@Data
public class User {

    private Integer id;

    private String name;

    private List<Person> people;
}
