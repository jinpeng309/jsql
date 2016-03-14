package com.capslock.jsql;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.OrderExpress;
import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.literal.StringLiteralExpress;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.express.operator.Order;
import com.capslock.jsql.express.query.ColumnsExpress;
import com.capslock.jsql.express.query.FromExpress;
import com.capslock.jsql.express.query.InsertIntoExpress;
import com.capslock.jsql.express.query.LimitExpress;
import com.capslock.jsql.express.query.OrderByExpress;
import com.capslock.jsql.express.query.SelectExpress;
import com.capslock.jsql.express.query.ValuesExpress;
import com.capslock.jsql.express.query.WhereExpress;
import com.capslock.jsql.type.Visitor;

import java.util.List;

/**
 * Created by capslock.
 */
public class SqlBuilder implements Visitor {
    final StringBuilder sqlBuilder = new StringBuilder(128);

    private void append(final String sql) {
        sqlBuilder.append(sql);
    }

    private void append(final long value) {
        sqlBuilder.append(value);
    }

    private void deleteLast() {
        deleteLastN(1);
    }

    private void deleteLastN(final int n) {
        sqlBuilder.delete(sqlBuilder.length() - n, sqlBuilder.length());
    }

    public void visit(final LiteralExpression expression) {
        append(expression.getLiteral().toString());
    }

    public void visit(final Operation<?> operation) {
        final Operator operator = operation.getOperator();
        if (Operators.biOperandSet.contains(operator)) {
            operation.getArg(0).accept(this);
            append(" ");
            append(operator.getOperand());
            append(" ");
            operation.getArg(1).accept(this);
        } else {
            append(operator.getOperand());
            append(" ");
            operation.getArg(0).accept(this);
        }
    }

    @Override
    public void visit(final SelectExpress selectExpress) {
        append("SELECT ");

        for (final Express columnExpress : selectExpress.getColumns()) {
            columnExpress.accept(this);
            append(" , ");
        }

        deleteLastN(3);
    }

    @Override
    public void visit(final FromExpress fromExpress) {
        append(" FROM ");

        for (final Express tabaleExpress : fromExpress.getFromTableExpressList()) {
            tabaleExpress.accept(this);
            append(" , ");
        }

        deleteLastN(3);
    }

    @Override
    public void visit(final WhereExpress whereExpress) {
        append(" WHERE ");
        whereExpress.getConditionExpress().accept(this);
    }

    @Override
    public void visit(final OrderExpress orderExpress) {
        append(" ORDER BY ");
        final Order order = orderExpress.getOrder();
        orderExpress.getExpress().accept(this);
        if (order == Order.desc) {
            append(" DESC");
        }
    }

    @Override
    public void visit(final OrderByExpress orderByExpress) {
        orderByExpress.getOrderExpress().accept(this);
    }

    @Override
    public void visit(final LimitExpress limitExpress) {
        append(" LIMIT ");
        append(limitExpress.getLimit());
    }

    @Override
    public void visit(final InsertIntoExpress insertExpress) {
        append("INSERT INTO ");
        insertExpress.getTableExpress().accept(this);
    }

    @Override
    public void visit(final ColumnsExpress columnsExpress) {
        final List<StringLiteralExpress> columns = columnsExpress.getColumns();

        if (!columns.isEmpty()) {
            append(" (");
            for (final StringLiteralExpress column : columns) {
                column.accept(this);
                append(" , ");
            }
            deleteLastN(3);
            append(")");
        }

    }

    @Override
    public void visit(final ValuesExpress valuesExpress) {
        final List<Express> valueList = valuesExpress.getValues();
        append(" VALUES ");
        append("(");
        if (!valueList.isEmpty()) {
            for (final Express value : valuesExpress.getValues()) {
                value.accept(this);
                append(" , ");
            }
            deleteLastN(3);
        }
        append(")");
    }

    public String build() {
        return sqlBuilder.toString();
    }
}
