package com.ohaotian.feifuzeng.multidb.dao.second;

import com.ohaotian.feifuzeng.multidb.dao.second.po.SecondUser;

import java.util.List;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TOOD
 * @Date 2019/1/29 10:48
 */
public interface UserInfoMapper {

    /**
     * 查询全量数据
     * @return
     */
    public List<SecondUser> getList();
}
