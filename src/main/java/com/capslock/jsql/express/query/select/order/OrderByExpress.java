package com.capslock.jsql.express.query.select.order;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.query.select.LimitExpress;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class OrderByExpress extends Query implements Express {
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
