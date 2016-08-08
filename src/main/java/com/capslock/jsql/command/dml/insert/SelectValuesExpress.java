package com.capslock.jsql.command.dml.insert;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;

/**
 * Created by capslock.
 */
public class SelectValuesExpress extends Command implements Express {
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
