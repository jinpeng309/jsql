package com.capslock.jsql;

import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class SqlBuilder implements Visitor {
    final StringBuilder sqlBuilder = new StringBuilder(128);

    private void append(final String sql) {
        sqlBuilder.append(sql);
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
        }
    }

    @Override
    public void visit(final SelectExpress selectExpress) {
        append("SELECT ");

        selectExpress.getColumns().forEach(express -> {
            express.accept(this);
            append(" , ");
        });

        deleteLastN(3);
    }

    @Override
    public void visit(final FromExpress fromExpress) {
        append(" FROM ");
        fromExpress.getFromTableExpressList().forEach(express -> {
            express.accept(this);
            append(" , ");
        });
        deleteLastN(2);
    }

    @Override
    public void visit(final WhereExpress whereExpress) {
        append(" WHERE ");
        whereExpress.getConditionExpress().accept(this);
    }

    public String build() {
        return sqlBuilder.toString();
    }
}
