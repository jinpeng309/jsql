package com.capslock.jsql.express.query.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;

import java.util.List;

/**
 * Created by capslock.
 */
public class ValuesExpress extends Query implements Express {
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
