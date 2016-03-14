package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.SqlContext;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

/**
 * Created by capslock.
 */
public class SelectExpress extends Query {
    private final ImmutableList<Express<?>> columns;

    public SelectExpress(final SqlContext sqlContext, final Express<?>... columns) {
        super(sqlContext);
        this.columns = ImmutableList.copyOf(columns);
    }

    public SelectExpress(final SqlContext sqlContext, final Express<?> column) {
        super(sqlContext);
        this.columns = ImmutableList.<Express<?>>of(column);
    }

    public ImmutableList<Express<?>> getColumns() {
        return columns;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public FromExpress from(final Express<?>... tableExpress) {
        final FromExpress fromExpress = new FromExpress(this, tableExpress);
        return fromExpress;
    }
}
