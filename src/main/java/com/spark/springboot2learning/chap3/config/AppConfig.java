package com.spark.springboot2learning.chap3.config;

import com.spark.springboot2learning.chap3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author initiald0824
 * @date 2019/8/1 11:27
 */
@Configuration
@ComponentScan(basePackages = "com.spark.springboot2learning.chap3.*",
                excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})
public class AppConfig {
    /**
     * 条件加载
     * @return
     */
    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/test");
        props.setProperty("username", "root");
        props.setProperty("password", "root");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
