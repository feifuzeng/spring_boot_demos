package com.ohaotian.feifz.style.study.json;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 解析xml文件成json串
 * @Date 2018/12/12 20:03
 */
public class JsonUtils {

    public static String xml2jsonString() throws JSONException, IOException {
        InputStream in = JsonUtils.class.getResourceAsStream("student.xml");
        String xml = IOUtils.toString(in, Charset.defaultCharset());
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj.toString();
    }

    public static void main(String[] args) throws JSONException, IOException {
        String string = xml2jsonString();
        System.out.println(string);

    }
}
