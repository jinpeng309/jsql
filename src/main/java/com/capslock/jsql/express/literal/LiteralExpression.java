package com.capslock.jsql.express.literal;

import com.capslock.jsql.express.BooleanExpress;
import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.ExpressionFactory;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.type.Visitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by capslock.
 */
public abstract class LiteralExpression<T extends Comparable> implements Express {
    protected final T value;

    public LiteralExpression(final T value) {
        this.value = value;
    }


    public T getLiteral() {
        return value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public BooleanExpress eq(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.EQ, this, right);
    }

    public BooleanExpress eq(final String right) {
        return eq(StringLiteralExpress.getStringLiteralExpressWithoutWrap(right));
    }

    public <T extends Number> BooleanExpress eq(final T right) {
        return eq(right.toString());
    }

    public BooleanExpress le(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.LE, this, right);
    }

    public BooleanExpress le(final String right) {
        return le(StringLiteralExpress.getStringLiteralExpressWithoutWrap(right));
    }

    public <T extends Number> BooleanExpress le(final T right) {
        return le(right.toString());
    }

    public BooleanExpress gt(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.GT, this, right);
    }

    public BooleanExpress gt(final String right) {
        return gt(StringLiteralExpress.getStringLiteralExpressWithoutWrap(right));
    }

    public <T extends Number> BooleanExpress gt(final T right) {
        return gt(right.toString());
    }

    public <T extends Number> BooleanExpress in(final T... right) {
        return in(Arrays.stream(right).map(Object::toString).collect(Collectors.toList()));
    }

    public BooleanExpress in(final String... right) {
        return in(Arrays.stream(right).map(str -> "'"+str+"'").collect(Collectors.toList()));
    }

    private BooleanExpress in(final Collection<String> right) {
        return ExpressionFactory.booleanOperation(Operators.IN, this,
                ExpressionFactory.stringLiteralExpressWithSeparator(right, ","));
    }

    public BooleanExpress in(final String right) {
        return in(Collections.singleton(right));
    }

}

