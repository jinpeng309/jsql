package com.capslock.jsql.express.literal;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.ExpressionFactory;
import com.capslock.jsql.express.booleanExpress.BooleanExpress;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.express.operator.Order;
import com.capslock.jsql.express.command.dml.select.order.OrderExpress;
import com.capslock.jsql.type.Visitor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public OrderExpress asc() {
        return new OrderExpress(this, Order.asc);
    }

    public OrderExpress desc() {
        return new OrderExpress(this, Order.desc);
    }

    public BooleanExpress eq(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.EQ, this, right);
    }

    public BooleanExpress eq(final String right) {
        return eq(StringLiteral.create(right));
    }

    public <N extends Number> BooleanExpress eq(final N right) {
        return eq(right.toString());
    }

    public BooleanExpress le(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.LE, this, right);
    }

    public BooleanExpress le(final String right) {
        return le(StringLiteral.create(right));
    }

    public <N extends Number> BooleanExpress le(final N right) {
        return le(right.toString());
    }

    public BooleanExpress gt(final Express<?> right) {
        return ExpressionFactory.booleanOperation(Operators.GT, this, right);
    }

    public BooleanExpress gt(final String right) {
        return gt(StringLiteral.create(right));
    }

    public <N extends Number> BooleanExpress gt(final N right) {
        return gt(right.toString());
    }

    public <N extends Number> BooleanExpress in(final N... right) {
        final List<String> numberList = new ArrayList<>();
        for (final N value : right) {
            numberList.add(value.toString());
        }
        return in(numberList);
    }

    public BooleanExpress in(final String... right) {
        return in(Lists.transform(ImmutableList.copyOf(right), new Function<String, String>() {
            @Override
            public String apply(final String str) {
                return "'" + str + "'";
            }
        }));
    }

    public BooleanExpress in(final Collection<?> right) {
        return ExpressionFactory.booleanOperation(Operators.IN, this,
                ExpressionFactory.stringLiteralExpressWithSeparator(right, ","));
    }

    public BooleanExpress in(final String right) {
        return in(Collections.singleton(right));
    }

}

