package com.capslock.jsql.visitor;

import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.command.dml.delete.DeleteExpress;
import com.capslock.jsql.command.dml.insert.ColumnsExpress;
import com.capslock.jsql.command.dml.insert.InsertExpress;
import com.capslock.jsql.command.dml.insert.SelectValuesExpress;
import com.capslock.jsql.command.dml.insert.ValuesExpress;
import com.capslock.jsql.command.dml.select.FromExpress;
import com.capslock.jsql.command.dml.select.LimitExpress;
import com.capslock.jsql.command.dml.select.SelectExpress;
import com.capslock.jsql.command.dml.select.WhereExpress;
import com.capslock.jsql.command.dml.select.order.OrderByExpress;
import com.capslock.jsql.command.dml.select.order.OrderExpress;
import com.capslock.jsql.command.dml.update.FollowSetExpress;
import com.capslock.jsql.command.dml.update.SetExpress;
import com.capslock.jsql.command.dml.update.UpdateExpress;

/**
 * Created by capslock.
 */
public interface Visitor {
    void visit(final LiteralExpression expression);

    void visit(final Operation<?> operation);

    void visit(final SelectExpress selectExpress);

    void visit(final FromExpress fromExpress);

    void visit(final WhereExpress whereExpress);

    void visit(final OrderExpress orderByExpress);

    void visit(final OrderByExpress orderByExpress);

    void visit(final LimitExpress limitExpress);

    void visit(final InsertExpress insertExpress);

    void visit(final ColumnsExpress columnsExpress);

    void visit(final ValuesExpress valuesExpress);

    void visit(final SelectValuesExpress selectValuesExpress);

    void visit(final DeleteExpress deleteExpress);

    void visit(final UpdateExpress updateExpress);

    void visit(final SetExpress setExpress);

    void visit(final FollowSetExpress followSetExpress);
}
