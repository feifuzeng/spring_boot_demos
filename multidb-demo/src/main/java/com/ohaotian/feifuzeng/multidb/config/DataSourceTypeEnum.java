package com.ohaotian.feifuzeng.multidb.config;

/**
 * 数据源枚举
 */
public enum DataSourceTypeEnum {

    FIRST_DB("first"),
    SECOND_DB("second");

    private String dataSource;

    private DataSourceTypeEnum(String dataSource){
        this.dataSource=dataSource;
    }

}
