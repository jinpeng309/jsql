package com.capslock.jsql.type;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.express.operator.Order;
import com.capslock.jsql.express.query.delete.DeleteExpress;
import com.capslock.jsql.express.query.insert.ColumnsExpress;
import com.capslock.jsql.express.query.insert.InsertExpress;
import com.capslock.jsql.express.query.insert.SelectValuesExpress;
import com.capslock.jsql.express.query.insert.ValuesExpress;
import com.capslock.jsql.express.query.select.FromExpress;
import com.capslock.jsql.express.query.select.LimitExpress;
import com.capslock.jsql.express.query.select.SelectExpress;
import com.capslock.jsql.express.query.select.WhereExpress;
import com.capslock.jsql.express.query.select.order.OrderByExpress;
import com.capslock.jsql.express.query.select.order.OrderExpress;
import com.capslock.jsql.express.query.update.FollowSetExpress;
import com.capslock.jsql.express.query.update.SetExpress;
import com.capslock.jsql.express.query.update.UpdateExpress;

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

    private void flush() {
        sqlBuilder.append("\n");
    }

    private void appendSpace() {
        append(" ");
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
            appendSpace();
            append(operator.getOperand());
            appendSpace();
            operation.getArg(1).accept(this);
        } else {
            append(operator.getOperand());
            appendSpace();
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
        appendSpace();
    }

    @Override
    public void visit(final FromExpress fromExpress) {
        flush();
        append("FROM ");

        for (final Express tabaleExpress : fromExpress.getFromTableExpressList()) {
            tabaleExpress.accept(this);
            append(" , ");
        }

        deleteLastN(3);
        appendSpace();
    }

    @Override
    public void visit(final WhereExpress whereExpress) {
        flush();
        append("WHERE ");
        whereExpress.getConditionExpress().accept(this);
        appendSpace();
    }

    @Override
    public void visit(final OrderExpress orderExpress) {
        flush();
        append("ORDER BY ");
        final Order order = orderExpress.getOrder();
        orderExpress.getExpress().accept(this);
        if (order == Order.desc) {
            append(" DESC");
        }
        appendSpace();
    }

    @Override
    public void visit(final OrderByExpress orderByExpress) {
        orderByExpress.getOrderExpress().accept(this);
    }

    @Override
    public void visit(final LimitExpress limitExpress) {
        flush();
        append("LIMIT ");
        append(limitExpress.getLimit());
        appendSpace();
    }

    @Override
    public void visit(final InsertExpress insertExpress) {
        append(insertExpress.getName());
        insertExpress.getTableExpress().accept(this);
        appendSpace();
    }

    @Override
    public void visit(final ColumnsExpress columnsExpress) {
        final List<StringLiteral> columns = columnsExpress.getColumns();

        if (!columns.isEmpty()) {
            append(" (");
            for (final StringLiteral column : columns) {
                column.accept(this);
                append(" , ");
            }
            deleteLastN(3);
            append(")");
        }
        appendSpace();

    }

    @Override
    public void visit(final ValuesExpress valuesExpress) {
        final List<List<Express>> valuesList = valuesExpress.getValues();
        append(" VALUES ");

        if (!valuesList.isEmpty()) {
            for (final List<Express> values : valuesList) {
                if (!values.isEmpty()) {
                    append("(");
                    for (final Express value : values) {
                        value.accept(this);
                        append(" , ");
                    }
                    deleteLastN(3);
                    append(")");
                }
                append(" , ");
            }
            deleteLastN(3);
            appendSpace();
        }

    }

    @Override
    public void visit(final SelectValuesExpress selectValuesExpress) {
        flush();
        selectValuesExpress.getSelectClause().accept(this);
    }

    @Override
    public void visit(final DeleteExpress deleteExpress) {
        flush();
        append("DELETE");
        appendSpace();
    }

    @Override
    public void visit(final UpdateExpress updateExpress) {
        flush();
        append("UPDATE ");
        updateExpress.getTable().accept(this);
        appendSpace();
    }

    @Override
    public void visit(final SetExpress setExpress) {
        flush();
        append("SET ");
        setExpress.getColumn().accept(this);
        append("=");
        setExpress.getValue().accept(this);
        appendSpace();

    }

    @Override
    public void visit(final FollowSetExpress followSetExpress) {
        append(", ");
        followSetExpress.getColumn().accept(this);
        append("=");
        followSetExpress.getValue().accept(this);
        appendSpace();
    }

    public String build() {
        return sqlBuilder.toString();
    }
}
