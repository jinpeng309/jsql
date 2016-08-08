package com.capslock.jsql.express.command.dml.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.command.Command;
import com.capslock.jsql.express.command.SqlContext;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

/**
 * Created by capslock.
 */
public class InsertExpress extends Command implements Express {
    private final Express<?> tableExpress;
    private final String name;

    public InsertExpress(final SqlContext sqlContext, final Express<?> tableExpress, final String name) {
        super(sqlContext);
        this.tableExpress = tableExpress;
        this.name = name;
    }

    public Express<?> getTableExpress() {
        return tableExpress;
    }

    public ColumnsExpress columns(final StringLiteral... columns) {
        return new ColumnsExpress(this, ImmutableList.copyOf(columns));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
