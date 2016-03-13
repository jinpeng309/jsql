package com.capslock.jsql.type;

import com.capslock.jsql.FromExpress;
import com.capslock.jsql.SelectExpress;
import com.capslock.jsql.WhereExpress;
import com.capslock.jsql.express.literal.LiteralExpression;
import com.capslock.jsql.express.operation.Operation;

/**
 * Created by capslock.
 */
public interface Visitor {
    void visit(final LiteralExpression expression);

    void visit(final Operation<?> operation);

    void visit(final SelectExpress selectExpress);

    void visit(final FromExpress fromExpress);

    void visit(final WhereExpress whereExpress);
}
