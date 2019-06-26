package com.github.feifuzeng.style.utils.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

/**
 * @author feifz
 * @version 1.0.0
 * @Description SerializerFeature特性的使用
 * @createTime 2019年06月10日 16:40:00
 */
public class SerializerFeatureTest {

    public static void main(String[] args) {
        User user = new User();
        user.setId(11L);
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.UseSingleQuotes);
        System.out.println(jsonString);

    }

}
