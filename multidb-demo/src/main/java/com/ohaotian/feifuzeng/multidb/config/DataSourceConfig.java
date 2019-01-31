package com.ohaotian.feifuzeng.multidb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author feifz
 * @version 1.0.0
 * @Description 数据源配置类
 * @Date 2019/1/28 14:59
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }
}

