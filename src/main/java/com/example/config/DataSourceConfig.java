package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource("classpath:/spring/datasource.xml")
@MapperScan("com.example.mapper")
public class DataSourceConfig {

}