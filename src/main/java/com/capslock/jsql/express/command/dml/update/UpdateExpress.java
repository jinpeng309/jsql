package com.capslock.jsql.express.command.dml.update;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.command.Command;
import com.capslock.jsql.express.command.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class UpdateExpress extends Command {
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

    public <N extends Number> SetExpress set(final Express column, final N value) {
        return new SetExpress(this, column, StringLiteral.create(value.toString()));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
