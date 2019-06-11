package com.ohaotian.feifz.style.study.utils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * @author feifz
 * @version 1.0.0
 * @Description @JSONType 注解使用示例
 * @createTime 2019年06月11日 14:41:00
 */
@JSONType(includes = {"name","age"},ignores = {"email"},orders = {"name","age"})
public class JsonTypeDemo {

    private String name;

    private String age;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JsonTypeDemo(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "JsonTypeDemo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        JsonTypeDemo demo = new JsonTypeDemo("Mary","17","123@163.com");
        System.out.println(JSON.toJSONString(demo));

        String json = "{\"age\":\"17\",\"email\":\"123@163.com\",\"name\":\"Mary\"}";
        JsonTypeDemo jsonTypeDemo = JSON.parseObject(json,JsonTypeDemo.class);
        System.out.println(jsonTypeDemo.toString());
    }
}
