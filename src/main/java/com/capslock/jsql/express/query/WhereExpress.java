package com.capslock.jsql.express.query;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class WhereExpress extends Query implements Express {
    private final Express<?> conditionExpress;

    public WhereExpress(final SqlBuilder visitor, final Express<?> condition) {
        super(visitor);
        this.conditionExpress = condition;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public Express<?> getConditionExpress() {
        return conditionExpress;
    }
}
