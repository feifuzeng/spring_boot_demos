package com.github.feifuzeng.style.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 测试model
 * @createTime 2019年06月27日 10:40:00
 */
@Component
@Scope("prototype")
public class Order {
    private String orderNum = "test";

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum='" + orderNum + '\'' +
                '}';
    }
}