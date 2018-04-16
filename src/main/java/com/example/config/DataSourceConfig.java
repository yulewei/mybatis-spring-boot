package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_LogFilter
 */
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:/spring/datasource.xml")
@MapperScan("com.example.mapper")
public class DataSourceConfig {

    @Bean
    public Slf4jLogFilterEx logFilter() {
        Slf4jLogFilterEx logFilter = new Slf4jLogFilterEx();
//        logFilter.setConnectionLogEnabled(false);
//        logFilter.setResultSetLogEnabled(false);
//        logFilter.setStatementCloseAfterLogEnabled(false);
//        logFilter.setStatementCreateAfterLogEnabled(false);
//        logFilter.setStatementExecutableSqlLogEnable(true);
//        logFilter.setStatementExecuteAfterLogEnabled(true);
//        logFilter.setStatementParameterSetLogEnabled(false);
//        logFilter.setStatementPrepareAfterLogEnabled(false);
//        logFilter.setStatementSqlFormatOption(new SQLUtils.FormatOption(false, false, false));
        return logFilter;
    }

}