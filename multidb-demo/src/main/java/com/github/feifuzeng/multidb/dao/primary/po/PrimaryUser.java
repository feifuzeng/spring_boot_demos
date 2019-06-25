package com.github.feifuzeng.multidb.dao.primary.po;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 用户信息基类
 * @Date 2019/1/28 15:37
 */
public class PrimaryUser {

    private Integer id;

    private String username;

    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
