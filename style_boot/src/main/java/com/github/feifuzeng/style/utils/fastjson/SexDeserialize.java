package com.github.feifuzeng.style.utils.fastjson;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年06月11日 10:24:00
 */

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class SexDeserialize implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser,
                            Type type,
                            Object fieldName) {


        String sex = parser.parseObject(String.class);
        if ("男".equals(sex)) {
            return (T) Boolean.TRUE;
        } else {
            return (T) Boolean.FALSE;
        }
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.UNDEFINED;
    }

}
