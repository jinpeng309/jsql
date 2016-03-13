package com.capslock.jsql.express;

import com.capslock.jsql.express.operation.OperationImpl;
import com.capslock.jsql.express.operator.Operator;

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
            //// TODO: 2016/3/11 add actual code
            not = this;
        }
        return not;
    }
}
