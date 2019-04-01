package com.ohaotian.feifz.style.study.controller;

import com.ohaotian.feifz.style.study.dao.UserMapper;
import com.ohaotian.feifz.style.study.model.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

}
