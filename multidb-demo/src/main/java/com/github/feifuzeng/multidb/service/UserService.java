package com.github.feifuzeng.multidb.service;

import com.github.feifuzeng.multidb.dao.primary.po.PrimaryUser;
import com.github.feifuzeng.multidb.dao.second.po.SecondUser;

import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/28 15:34
 */
public interface UserService {


    /***  DB1  相关方法*/

    /**
     * 查询db1中用户表所有信息
     * @return
     */
    public List<PrimaryUser> getListdbone();

    /**
     * 插入数据
     * @param primaryUser
     */
    public void addPrimary(PrimaryUser primaryUser);

    /***  DB1  相关方法*/
    /**
     * 查询db2中用户表所有信息
     * @return
     */
    public List<SecondUser> getListdbtwo();
}
