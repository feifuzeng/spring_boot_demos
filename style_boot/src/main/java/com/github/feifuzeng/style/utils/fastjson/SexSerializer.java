package com.github.feifuzeng.style.utils.fastjson;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年06月11日 10:23:00
 */

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class SexSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer,
                      Object object,
                      Object fieldName,
                      Type fieldType,
                      int features)
            throws IOException {
        Boolean value = (Boolean) object;
        String text = "女";
        if (value != null && value == true) {
            text = "男";
        }
        serializer.write(text);
    }

}