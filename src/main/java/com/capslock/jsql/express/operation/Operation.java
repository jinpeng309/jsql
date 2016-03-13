package com.capslock.jsql.express.operation;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.operator.Operator;

import java.util.List;

/**
 * Created by capslock.
 */
public interface Operation<T> extends Express<T> {
    Express<?> getArg(final int index);

    List<Express<?>> getArgs();

    Operator getOperator();
}
