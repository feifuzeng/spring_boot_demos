package com.ohaotian.feifuzeng.multidb.dao.primary;

import com.ohaotian.feifuzeng.multidb.dao.primary.po.PrimaryUser;

import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/29 10:47
 */
public interface UserMapper {

    /**
     * 查询全量数据
     * @return
     */
    public List<PrimaryUser> getList();

    /**
     * 插入数据
     * @param primaryUser
     */
    public void addPrimary(PrimaryUser primaryUser);
}
