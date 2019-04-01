package com.ohaotian.feifz.style.study.model.po;

import lombok.Data;

/**
 * @Author: feifz
 * @Date: 2019-04-01 14:19
 * @Version: 1.0
 * @Description: TODO
 */
@Data
public class User {
    // 主键
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;

}
