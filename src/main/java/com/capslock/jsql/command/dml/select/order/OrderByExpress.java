package com.capslock.jsql.command.dml.select.order;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.command.dml.select.LimitExpress;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;

/**
 * Created by capslock.
 */
public class OrderByExpress extends Command implements Express {
    private final OrderExpress orderExpress;

    public OrderByExpress(final SqlContext sqlContext, OrderExpress orderExpress) {
        super(sqlContext);
        this.orderExpress = orderExpress;
    }

    public OrderExpress getOrderExpress() {
        return orderExpress;
    }

    public LimitExpress limit(final long limit) {
        return new LimitExpress(this, limit);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
