package com.capslock.jsql.express.operation;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.operator.Operator;
import com.capslock.jsql.type.Visitor;

import java.util.List;

/**
 * Created by capslock.
 */
public class OperationImpl<T> implements Operation<T> {
    private final Operator operator;
    private final List<Express<?>> args;

    public OperationImpl(final Operator operator, final List<Express<?>> args) {
        this.operator = operator;
        this.args = args;
    }

    public Operator getOperator() {
        return operator;
    }

    public final Express<?> getArg(final int index) {
        return args.get(index);
    }

    public final List<Express<?>> getArgs() {
        return args;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
