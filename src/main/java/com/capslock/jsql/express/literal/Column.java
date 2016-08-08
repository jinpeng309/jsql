package com.capslock.jsql.express.literal;

import com.capslock.jsql.express.operator.Order;
import com.capslock.jsql.express.command.dml.select.order.OrderExpress;

/**
 * Created by capslock.
 */
public class Column extends StringLiteral {
    public Column(final String value) {
        super("`" + value + "`");
    }

    public OrderExpress orderByAsc() {
        return new OrderExpress(this, Order.asc);
    }

    public OrderExpress orderByDesc() {
        return new OrderExpress(this, Order.desc);
    }
}
