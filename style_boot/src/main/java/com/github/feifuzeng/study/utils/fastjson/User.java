package com.github.feifuzeng.study.utils.fastjson;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 研究fastjson用到的对象
 * @createTime 2019年06月10日 16:36:00
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(serializeUsing = SexSerializer.class, deserializeUsing = SexDeserialize.class)
    private Boolean sex;

}
