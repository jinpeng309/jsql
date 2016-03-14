package com.capslock.jsql.express.booleanExpress;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.ExpressionFactory;
import com.capslock.jsql.express.operation.OperationImpl;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.express.operator.Operators;

import java.util.List;

/**
 * Created by capslock.
 */
public class PredicateOperation extends OperationImpl<Boolean> implements Predicate {
    private Predicate not;

    public PredicateOperation(final Operator operator, final List<Express<?>> args) {
        super(operator, args);
    }

    public Predicate not() {
        if (not == null) {
            not = ExpressionFactory.booleanOperation(Operators.NOT, this);
        }
        return not;
    }
}
