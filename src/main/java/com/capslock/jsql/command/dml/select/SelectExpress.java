package com.capslock.jsql.command.dml.select;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;
import com.google.common.collect.ImmutableList;

/**
 * Created by capslock.
 */
public class SelectExpress extends Command {
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
        return new FromExpress(this, tableExpress);
    }
}
