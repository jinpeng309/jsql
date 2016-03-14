package com.capslock.jsql.express.query.order;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.operator.Order;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class OrderExpress implements Express {
    private final Express<?> express;
    private final Order order;

    public OrderExpress(final Express<?> express, final Order order) {
        this.express = express;
        this.order = order;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public Order getOrder() {
        return order;
    }

    public Express<?> getExpress() {
        return express;
    }
}
