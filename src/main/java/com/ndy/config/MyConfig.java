package com.ndy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyConfig  {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource DruidData(){
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;


    }
}
