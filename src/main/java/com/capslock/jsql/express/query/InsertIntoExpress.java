package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteralExpress;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

/**
 * Created by alvin.
 */
public class InsertIntoExpress extends Query implements Express {
    private final Express<?> tableExpress;

    public InsertIntoExpress(final SqlContext sqlContext, final Express<?> tableExpress) {
        super(sqlContext);
        this.tableExpress = tableExpress;
    }

    public Express<?> getTableExpress() {
        return tableExpress;
    }

    public ColumnsExpress columns(final StringLiteralExpress... columns) {
        return new ColumnsExpress(this, ImmutableList.copyOf(columns));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
