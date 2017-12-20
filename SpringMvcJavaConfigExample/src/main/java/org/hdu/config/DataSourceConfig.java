package org.hdu.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mapstruct.BeanMapping;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String passWord;

    @Value("${jdbc.driver.psql}")
    private String pDriverClassName;

    @Value("${jdbc.url.psql}")
    private String pUrl;

    @Value("${jdbc.username.psql}")
    private String pUserName;

    @Value("${jdbc.password.psql}")
    private String pPassWord;


    @Bean(value = "psqlDataSource")
    public BasicDataSource psqlDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(pDriverClassName);
        dataSource.setUrl(pUrl);
        dataSource.setUsername(pUserName);
        dataSource.setPassword(passWord);
        return dataSource;
    }

    @Bean(value = "mysqlDataSource")
    public BasicDataSource mysqlDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }

}
