package com.capslock.jsql.command.dml.select;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;

/**
 * Created by capslock.
 */
public class LimitExpress extends Command implements Express {
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
