package com.ohaotian.feifuzeng.multidb.control;

import com.ohaotian.feifuzeng.multidb.dao.primary.po.PrimaryUser;
import com.ohaotian.feifuzeng.multidb.dao.second.po.SecondUser;
import com.ohaotian.feifuzeng.multidb.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/29 11:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *
     * @return
     */
    @RequestMapping("/getListdbone")
    @ResponseBody
    public List<PrimaryUser> getListdbone(){
        return userService.getListdbone();
    }

    /**
     *
     * @return
     */
    @RequestMapping("/getListdbtwo")
    @ResponseBody
    public List<SecondUser> getListdbtwo(){
        return userService.getListdbtwo();
    }
}
