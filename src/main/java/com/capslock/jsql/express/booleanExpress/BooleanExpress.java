package com.capslock.jsql.express.booleanExpress;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.ExpressionFactory;
import com.capslock.jsql.express.operator.Operators;

/**
 * Created by capslock.
 */
public abstract class BooleanExpress implements Predicate {
    private BooleanExpress not;
    protected final Express<Boolean> express;

    public BooleanExpress(final Express<Boolean> express) {
        this.express = express;
    }

    public BooleanExpress not() {
        if (not == null) {
            not = ExpressionFactory.booleanOperation(Operators.NOT, this);
        }
        return not;
    }

    public BooleanExpress and(final Predicate predicate) {
        return ExpressionFactory.booleanOperation(Operators.AND, this, predicate);
    }

    public BooleanExpress or(final Predicate predicate) {
        return ExpressionFactory.booleanOperation(Operators.OR, this, predicate);
    }
}
