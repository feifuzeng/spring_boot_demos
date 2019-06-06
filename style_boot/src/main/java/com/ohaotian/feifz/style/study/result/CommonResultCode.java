package com.ohaotian.feifz.style.study.result;

import java.io.Serializable;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 错误码
 * @Date 2018/9/26 15:22
 */
public enum CommonResultCode implements IErrorCode, Serializable {

    /**
     * 失败
     */
    FAIL("1","%s"),
    /**
     * 成功
     */
    SUCCESS("0", "成功");

    public final String code;
    public final String message;

    CommonResultCode(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
