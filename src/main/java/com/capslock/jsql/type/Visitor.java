package com.capslock.jsql.type;

import com.capslock.jsql.express.query.insert.SelectValuesExpress;
import com.capslock.jsql.express.query.select.order.OrderExpress;
import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.express.query.insert.ColumnsExpress;
import com.capslock.jsql.express.query.select.FromExpress;
import com.capslock.jsql.express.query.insert.InsertExpress;
import com.capslock.jsql.express.query.select.LimitExpress;
import com.capslock.jsql.express.query.select.order.OrderByExpress;
import com.capslock.jsql.express.query.select.SelectExpress;
import com.capslock.jsql.express.query.insert.ValuesExpress;
import com.capslock.jsql.express.query.select.WhereExpress;

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
}
