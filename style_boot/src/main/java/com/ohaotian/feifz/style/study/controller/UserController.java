package com.ohaotian.feifz.style.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ohaotian.feifz.style.study.dao.UserMapper;
import com.ohaotian.feifz.style.study.model.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 14:29
 * @Version: 1.0
 * @Description: TODO
 */
@Controller
public class UserController {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询全量用户列表
     *
     * @return
     */
    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser() {
        List<User> users = userMapper.queryUserList();
        return users;
    }

    /**
     * 批量增加用户
     * @param userList
     */
    @RequestMapping("/addUsers")
    @ResponseBody
    public void addUsers(@RequestBody List<User> userList){
        userList.forEach(user -> System.out.println(user.getName()));
    }


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(123L);
        user.setName("张三");
        User user1 = new User();
        user1.setId(234L);
        user1.setName("李四");
        users.add(user);
        users.add(user1);

        JSONArray array= JSONArray.parseArray(JSON.toJSONString(users));
        System.out.println(array);
    }
}
