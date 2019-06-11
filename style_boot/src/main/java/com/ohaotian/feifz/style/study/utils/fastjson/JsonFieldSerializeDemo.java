package com.ohaotian.feifz.style.study.utils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author feifz
 * @version 1.0.0
 * @Description @JSONField name属性示例
 * @createTime 2019年06月11日 14:09:00
 */
public class JsonFieldSerializeDemo {

    private String name;

    @JSONField(deserialize = false)
    private String age;

    @JSONField(serialize = false)
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

    @Override
    public String toString() {
        return "JsonFieldSerializeDemo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        JsonFieldSerializeDemo jsonFieldNameTest1 = new JsonFieldSerializeDemo();
        jsonFieldNameTest1.setAge("18");
        jsonFieldNameTest1.setEmail("123@163.com");
        jsonFieldNameTest1.setName("Bob");
        System.out.println(JSON.toJSONString(jsonFieldNameTest1));

        String json = "{\"age\":\"18\",\"email\":\"123@163.com\",\"name\":\"Bob\"}";
        JsonFieldSerializeDemo jsonFieldNameTest2 = JSON.parseObject(json, JsonFieldSerializeDemo.class);
        System.out.println(jsonFieldNameTest2.toString());

    }
}
