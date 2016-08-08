package com.capslock.jsql.command.dml.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;

import java.util.List;

/**
 * Created by capslock.
 */
public class ValuesExpress extends Command implements Express {
    private final List<List<Express>> values;

    public ValuesExpress(final SqlContext sqlContext, final List<List<Express>> values) {
        super(sqlContext);
        this.values = values;
    }

    public List<List<Express>> getValues() {
        return values;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
