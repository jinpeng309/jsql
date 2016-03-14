package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class OrderByExpress extends Query implements Express {

    public OrderByExpress(final SqlContext sqlContext) {
        super(sqlContext);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
