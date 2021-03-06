package com.capslock.jsql.express.booleanExpress;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.operation.Operation;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.visitor.Visitor;

import java.util.List;

/**
 * Created by capslock.
 */
public class BooleanOperationExpress extends BooleanExpress implements Operation<Boolean> {
    private final PredicateOperation predicateOperation;

    public BooleanOperationExpress(final Operator operator, final List<Express<?>> args) {
        super(new PredicateOperation(operator, args));
        this.predicateOperation = (PredicateOperation) express;
    }

    public Express<?> getArg(final int index) {
        return predicateOperation.getArg(index);
    }

    public List<Express<?>> getArgs() {
        return predicateOperation.getArgs();
    }

    public Operator getOperator() {
        return predicateOperation.getOperator();
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
