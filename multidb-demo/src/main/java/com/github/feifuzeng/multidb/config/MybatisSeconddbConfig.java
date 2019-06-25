package com.github.feifuzeng.multidb.config;

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
 * @Description Mybatis SqlSessionFactory多数据源配置-db B配置
 * @Date 2019/1/28 15:31
 */
@Configuration
@MapperScan(basePackages = {"com.ohaotian.feifuzeng.multidb.dao.second"}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisSeconddbConfig {
    public static final String MAPPER_LOCATION = "classpath:mapper/second/*.xml";

    @Autowired
    @Qualifier("secondDataSource")
    private DataSource ds2;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds2);
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(MybatisSeconddbConfig.MAPPER_LOCATION);
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }
}
