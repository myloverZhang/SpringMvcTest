package org.hdu.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
@Configuration
public class SessionConfig {
    @Bean(name = "mysqlSessionFactoryBean")
    public SqlSessionFactoryBean mysqlSessionFactoryBean(@Qualifier("mysqlDataSource") BasicDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.cfg.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    @Bean(name = "psqlSessionFactoryBean")
    public SqlSessionFactoryBean psqlSessionFactoryBean(@Qualifier("psqlDataSource") BasicDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.cfg.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mysqlMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("org.hdu.mapper.students");
        configurer.setSqlSessionFactoryBeanName("mysqlSessionFactoryBean");
        return configurer;
    }
    @Bean
    public MapperScannerConfigurer psqlMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("org.hdu.mapper.school");
        configurer.setSqlSessionFactoryBeanName("psqlSessionFactoryBean");
        return configurer;
    }
}
