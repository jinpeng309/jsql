package com.capslock.jsql.express.query;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class OrderByExpress extends Query implements Express {

    public OrderByExpress(final SqlBuilder visitor) {
        super(visitor);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
