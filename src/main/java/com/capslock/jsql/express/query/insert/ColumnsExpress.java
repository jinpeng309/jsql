package com.capslock.jsql.express.query.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by alvin.
 */
public class ColumnsExpress extends Query implements Express {
    private final List<StringLiteral> columns;

    public ColumnsExpress(final SqlContext sqlContext, List<StringLiteral> columns) {
        super(sqlContext);
        this.columns = columns;
    }

    public ValuesExpress values(final Express... values){
        return new ValuesExpress(this, ImmutableList.copyOf(values));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public List<StringLiteral> getColumns() {
        return columns;
    }
}
