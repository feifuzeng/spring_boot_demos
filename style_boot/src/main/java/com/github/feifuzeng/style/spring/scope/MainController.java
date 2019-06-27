package com.github.feifuzeng.style.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 测试controller
 * @createTime 2019年06月27日 10:41:00
 */
@Controller
@RequestMapping(value = "/api")
@Scope("prototype")
public class MainController {
    @Autowired
    private Order order;

    private String name;

    @RequestMapping(value = "/users/{username}",method = RequestMethod.GET)
    @ResponseBody
    public String userProfile(@PathVariable("username") String username) {
        name = username;
        order.setOrderNum( name);
        try {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getId() + "name:" + name + "--order:" + order.getOrderNum());
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
        return order.toString();
    }
}
