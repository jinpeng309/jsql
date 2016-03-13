package com.capslock.jsql;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

/**
 * Created by capslock.
 */
public class SelectExpress extends Query implements Express {
    private final ImmutableList<Express<?>> columns;

    public SelectExpress(final SqlBuilder sqlBuilder, final Express<?>... columns) {
        super(sqlBuilder);
        this.columns = ImmutableList.copyOf(columns);
    }

    public SelectExpress(final SqlBuilder sqlBuilder, final Express<?> column) {
        super(sqlBuilder);
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
        final FromExpress fromExpress = new FromExpress(sqlBuilder, tableExpress);
        fromExpress.accept(sqlBuilder);
        return fromExpress;
    }
}
