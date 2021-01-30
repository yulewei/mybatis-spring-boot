package com.example.common;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.proxy.jdbc.CallableStatementProxy;
import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.alibaba.druid.sql.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_LogFilter
 *
 * @author yulewei on 2018/4/16
 */
public class Slf4jLogFilterEx extends Slf4jLogFilter {

    public Slf4jLogFilterEx() {
        this.setConnectionLogEnabled(false);  // 默认 true
        this.setResultSetLogEnabled(false);   // 默认 true
        this.setStatementCloseAfterLogEnabled(false);   // 默认 true
        this.setStatementCreateAfterLogEnabled(false);  // 默认 true
        this.setStatementParameterSetLogEnabled(false);  // 默认 true
        this.setStatementPrepareAfterLogEnabled(false);  // 默认 true
        this.setStatementExecuteAfterLogEnabled(true);  // 默认 true，确保开启
        this.setStatementExecuteQueryAfterLogEnabled(true);  // 默认 true，确保开启
        this.setStatementLogErrorEnabled(true);          // 默认 true，确保开启
        // 输出的 SQL 修改为全部小写，禁用默认的格式化，并且填充实际参数
        this.setStatementSqlFormatOption(new SQLUtils.FormatOption(false, false, false));
    }

    @Override
    protected void statementExecuteQueryAfter(StatementProxy statement, String sql, ResultSetProxy resultSet) {
        if (isStatementExecuteQueryAfterLogEnabled() && isStatementLogEnabled()) {
            statement.setLastExecuteTimeNano();
            double nanos = statement.getLastExecuteTimeNano();
            double millis = nanos / (1000 * 1000);

            String formattedSql = this.buildFormattedSql(statement, sql);
            String message = String.format("{conn-%s, %s} query executed. %.2f millis.\t%s",
                    statement.getConnectionProxy().getId(), stmtId(statement), millis, formattedSql);
            this.statementLog(message);
        }
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean firstResult) {
        if (isStatementExecuteAfterLogEnabled() && isStatementLogEnabled()) {
            statement.setLastExecuteTimeNano();
            double nanos = statement.getLastExecuteTimeNano();
            double millis = nanos / (1000 * 1000);

            String formattedSql = this.buildFormattedSql(statement, sql);
            String message = String.format("{conn-%s, %s} executed. %.2f millis.\t%s",
                    statement.getConnectionProxy().getId(), stmtId(statement), millis, formattedSql);
            this.statementLog(message);
        }
    }

    @Override
    protected void statement_executeErrorAfter(StatementProxy statement, String sql, Throwable error) {
        if (this.isStatementLogErrorEnabled()) {
            String formattedSql = this.buildFormattedSql(statement, sql);
            String message = String.format("{conn-%s, %s} execute error.\t%s",
                    statement.getConnectionProxy().getId(), stmtId(statement), formattedSql);
            this.statementLogError(message, error);
        }
    }

    private String buildFormattedSql(StatementProxy statement, String sql) {
        int parametersSize = statement.getParametersSize();
        List<Object> parameters = new ArrayList<Object>(parametersSize);
        for (int i = 0; i < parametersSize; ++i) {
            JdbcParameter jdbcParam = statement.getParameter(i);
            parameters.add(jdbcParam != null ? jdbcParam.getValue() : null);
        }

        String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
        return SQLUtils.format(sql, dbType, parameters, this.getStatementSqlFormatOption());
    }

    private String stmtId(StatementProxy statement) {
        StringBuffer buf = new StringBuffer();
        if (statement instanceof CallableStatementProxy) {
            buf.append("cstmt-");
        } else if (statement instanceof PreparedStatementProxy) {
            buf.append("pstmt-");
        } else {
            buf.append("stmt-");
        }
        buf.append(statement.getId());

        return buf.toString();
    }

}
