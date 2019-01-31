package com.ohaotian.feifuzeng.multidb.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description Mybatis SqlSessionFactory多数据源配置-db A配置
 * @Date 2019/1/28 15:26
 */
@Configuration
@MapperScan(basePackages = {"com.ohaotian.feifuzeng.multidb.dao.primary"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisPrimarydbConfig {

    public static final String MAPPER_LOCATION = "classpath:mapper/primary/*.xml";

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 使用主数据源, 连接主库
        factoryBean.setDataSource(ds1);
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(MybatisPrimarydbConfig.MAPPER_LOCATION);
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory1());
    }
}
