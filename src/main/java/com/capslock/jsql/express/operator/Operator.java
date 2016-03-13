package com.capslock.jsql.express.operator;

/**
 * Created by capslock.
 */
public interface Operator {
    Class<?> getType();
    String getOperand();
}
