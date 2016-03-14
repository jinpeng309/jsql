package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.OrderExpress;
import com.capslock.jsql.type.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class WhereExpress extends Query implements Express {
    private final Express<?> conditionExpress;

    public WhereExpress(final SqlContext sqlContext, final Express<?> condition) {
        super(sqlContext);
        this.conditionExpress = condition;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public Express<?> getConditionExpress() {
        return conditionExpress;
    }

    public OrderByExpress orderBy(final OrderExpress orderExpress) {
        return new OrderByExpress(this);
    }

}
