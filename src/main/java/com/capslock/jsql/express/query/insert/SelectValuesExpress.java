package com.capslock.jsql.express.query.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class SelectValuesExpress extends Query implements Express {
    private final StringLiteral selectClause;

    public SelectValuesExpress(final SqlContext sqlContext, final StringLiteral selectExpress) {
        super(sqlContext);
        this.selectClause = selectExpress;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public StringLiteral getSelectClause() {
        return selectClause;
    }
}
