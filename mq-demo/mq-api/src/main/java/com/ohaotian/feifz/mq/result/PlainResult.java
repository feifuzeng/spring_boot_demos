package com.ohaotian.feifz.mq.result;

/**
 * @author feifz
 * @version 1.0.0
 * @Description PlainResult.java的实现描述：返回对象的泛型实现
 * @Date 2018/9/26 15:22
 */
public class PlainResult<T> extends BaseResult {

    private static final long serialVersionUID = -3767132392732612883L;

    /**
     * 调用返回的数据
     */
    private T data;

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    public PlainResult() {
        super();
    }

    public PlainResult(T data) {
        this.data = data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "success=" + this.isSuccess() +
                ",code=" + this.getCode() +
                ",message=" + this.getMessage() +
                ",data=" + data +
                '}';
    }
}
