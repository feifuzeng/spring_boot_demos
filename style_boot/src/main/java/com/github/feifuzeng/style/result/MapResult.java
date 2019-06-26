package com.github.feifuzeng.style.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feifz
 * @version 1.0.0
 * @Description MapResult.java的实现描述：返回Map的泛型实现
 * @Date 2018/9/26 15:22
 */
public class MapResult<T, K> extends BaseResult {
    private static final long serialVersionUID = -1044729443054115388L;

    private Map<T, K> data = new HashMap<T, K>();

    public Map<T, K> getData() {
        return data;
    }

    public void setData(Map<T, K> data) {
        this.data = data;
    }


}
