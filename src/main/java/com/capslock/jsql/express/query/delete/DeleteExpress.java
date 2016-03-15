package com.capslock.jsql.express.query.delete;

import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class DeleteExpress extends Query {

    public DeleteExpress(final SqlContext sqlContext) {
        super(sqlContext);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
