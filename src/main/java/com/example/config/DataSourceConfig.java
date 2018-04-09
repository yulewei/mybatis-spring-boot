package com.example.config;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.sql.SQLUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource("classpath:/spring/datasource.xml")
@MapperScan("com.example.mapper")
public class DataSourceConfig {

    @Bean
    public Slf4jLogFilter logFilter() {
        Slf4jLogFilter logFilter = new Slf4jLogFilter();
        logFilter.setConnectionLogEnabled(false);
        logFilter.setResultSetLogEnabled(false);
        logFilter.setStatementCloseAfterLogEnabled(false);
        logFilter.setStatementCreateAfterLogEnabled(false);
        logFilter.setStatementExecutableSqlLogEnable(true);
        logFilter.setStatementExecuteAfterLogEnabled(false);
        logFilter.setStatementParameterSetLogEnabled(false);
        logFilter.setStatementPrepareAfterLogEnabled(false);
        logFilter.setStatementSqlFormatOption(new SQLUtils.FormatOption(false, false, false));
        return logFilter;
    }

}