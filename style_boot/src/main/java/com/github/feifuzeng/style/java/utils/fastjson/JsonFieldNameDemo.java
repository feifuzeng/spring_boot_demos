package com.github.feifuzeng.style.java.utils.fastjson;

/**
 * @author feifz
 * @version 1.0.0
 * @Description JSONField注解 name属性用法
 * @createTime 2019年06月11日 14:00:00
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class JsonFieldNameDemo {

    @JSONField(name = "jsonName")
    private String name;

    private String age;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JSONField(name = "jsonAge")
    public String getAge() {
        return age;
    }

    @JSONField(name = "jsonAge")
    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    @JSONField(name = "jsonEmail")
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "JsonFieldNameDemo [name=" + name + ", age=" + age + ", email="
                + email + "]";
    }


    public static void main(String[] args) {

        JsonFieldNameDemo jsonFieldNameDemo = new JsonFieldNameDemo();
        jsonFieldNameDemo.setAge("21岁");
        jsonFieldNameDemo.setEmail("111@11.com");
        jsonFieldNameDemo.setName("hhh");

        System.out.println(JSON.toJSONString(jsonFieldNameDemo));
        //输出了：{"jsonName":"hhh","jsonAge":"21岁","email":"111@11.com"}

        String json = "{\"email\":\"111@11.com\",\"jsonAge\":\"21岁\",\"jsonName\":\"hhh\"}";
        JsonFieldNameDemo jsonTest = JSON.parseObject(json, JsonFieldNameDemo.class);
        System.out.println(jsonTest.toString());
    }

}
