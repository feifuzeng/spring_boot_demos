package com.ohaotian.feifz.style.study.dao;

import com.ohaotian.feifz.style.study.model.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-04-01 14:21
 * @Version: 1.0
 * @Description: TODO
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
