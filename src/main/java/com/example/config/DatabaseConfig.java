package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.common.Slf4jLogFilterEx;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

/***
 * 数据库相关配置
 */
@Configuration
public class DatabaseConfig {
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* cn.example..mapper..*.*(..))";

    @Resource
    private PlatformTransactionManager transactionManager;
    @Resource
    private DruidDataSource druidDataSource;

    /**
     * druid 设置自定义 Slf4jLogFilter
     */
    @PostConstruct
    public void setDruidProxyFilters() {
        druidDataSource.setProxyFilters(Collections.singletonList(new Slf4jLogFilterEx()));
    }

    /**
     * 查询相关的 SQL 自动设置为只读事务，只读事务的连接经过 {@link com.mysql.jdbc.ReplicationDriver} 将选择在从库下执行
     */
    @Bean
    public TransactionInterceptor txAdvice() {
        // 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务
        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));

        // 只读事务，不做更新操作
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        readOnly.setReadOnly(true);

        // 配置事务方法的前缀
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("*", required);
        source.addTransactionalMethod("get*", readOnly);
        source.addTransactionalMethod("find*", readOnly);
        source.addTransactionalMethod("has*", readOnly);
        source.addTransactionalMethod("count*", readOnly);
        source.addTransactionalMethod("search*", readOnly);
        source.addTransactionalMethod("select*", readOnly);
        source.addTransactionalMethod("query*", readOnly);
        source.addTransactionalMethod("batchList*", readOnly);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

}
