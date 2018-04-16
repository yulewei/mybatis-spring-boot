package com.example.config;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.proxy.jdbc.CallableStatementProxy;
import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
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
        this.setConnectionLogEnabled(false);
        this.setResultSetLogEnabled(false);
        this.setStatementCloseAfterLogEnabled(false);
        this.setStatementCreateAfterLogEnabled(false);
        this.setStatementExecutableSqlLogEnable(true);
        this.setStatementExecuteAfterLogEnabled(true);
        this.setStatementParameterSetLogEnabled(false);
        this.setStatementPrepareAfterLogEnabled(false);
        this.setStatementSqlFormatOption(new SQLUtils.FormatOption(false, false, false));
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean firstResult) {
        int parametersSize = statement.getParametersSize();
        List<Object> parameters = new ArrayList<Object>(parametersSize);
        for (int i = 0; i < parametersSize; ++i) {
            JdbcParameter jdbcParam = statement.getParameter(i);
            parameters.add(jdbcParam != null ? jdbcParam.getValue() : null);
        }

        String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
        String formattedSql = SQLUtils.format(sql, dbType, parameters, this.getStatementSqlFormatOption());

        if (isStatementExecuteAfterLogEnabled() && isStatementLogEnabled()) {
            statement.setLastExecuteTimeNano();
            double nanos = statement.getLastExecuteTimeNano();
            double millis = nanos / (1000 * 1000);

            String message = String.format("{conn-%s, %s} executed. %.2f millis.\n\t%s",
                    statement.getConnectionProxy().getId(), stmtId(statement), millis, formattedSql);
            statementLog(message);
        }
    }

    @Override
    protected void statement_executeErrorAfter(StatementProxy statement, String sql, Throwable error) {
        if (this.isStatementLogErrorEnabled()) {
            int parametersSize = statement.getParametersSize();
            List<Object> parameters = new ArrayList<Object>(parametersSize);
            for (int i = 0; i < parametersSize; ++i) {
                JdbcParameter jdbcParam = statement.getParameter(i);
                parameters.add(jdbcParam != null ? jdbcParam.getValue() : null);
            }
            String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
            String formattedSql = SQLUtils.format(sql, dbType, parameters, this.getStatementSqlFormatOption());

            String message = String.format("{conn-%s, %s} execute error.\n\t%s",
                    statement.getConnectionProxy().getId(), stmtId(statement), formattedSql);
            statementLogError(message, error);
        }
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
