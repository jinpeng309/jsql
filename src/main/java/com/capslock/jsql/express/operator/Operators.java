package com.capslock.jsql.express.operator;

import com.google.common.collect.ImmutableSet;

/**
 * Created by capslock.
 */
public enum Operators implements Operator {
    EQ(Boolean.class, "="),
    NE(Boolean.class, "!="),
    LE(Boolean.class, "<"),
    GT(Boolean.class, ">"),
    OR(Boolean.class, "OR"),
    AND(Boolean.class, "AND"),
    IN(Boolean.class, "IN"),
    NOT(Boolean.class, "NOT");

    private final Class<?> type;
    private final String operand;

    Operators(final Class<?> type, final String operand) {
        this.type = type;
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

    public Class<?> getType() {
        return type;
    }

    public static final ImmutableSet<Operator> biOperandSet = ImmutableSet.<Operator>of(
            EQ,
            NE,
            LE,
            GT,
            AND,
            OR,
            IN);
}
