package com.capslock.jsql.express.query.update;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class UpdateExpress extends Query {
    private final Express table;

    public UpdateExpress(final SqlContext sqlContext, final Express table) {
        super(sqlContext);
        this.table = table;
    }

    public Express getTable() {
        return table;
    }

    public SetExpress set(final Express column, final String value) {
        return new SetExpress(this, column, StringLiteral.createWithApostrophe(value));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
