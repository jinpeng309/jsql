package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class LimitExpress extends Query implements Express {
    private final long limit;

    public LimitExpress(final SqlContext sqlContext, final long limit) {
        super(sqlContext);
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
