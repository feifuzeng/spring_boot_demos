package com.ohaotian.feifz.style.study.result;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 类IErrorCode.java的实现描述：错误代码错误信息获取接口
 * @Date 2018/9/26 15:22
 */
public interface IErrorCode {
    /**
     * 获取错误码
     * @return
     */
    public String getCode();

    /**
     * 获取错误消息
     * @return
     */
    public String getMessage();
}
