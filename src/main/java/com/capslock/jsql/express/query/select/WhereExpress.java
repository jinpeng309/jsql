package com.capslock.jsql.express.query.select;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.express.query.select.order.OrderByExpress;
import com.capslock.jsql.express.query.select.order.OrderExpress;
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
        return new OrderByExpress(this, orderExpress);
    }

    public LimitExpress limit(final long limit){
        return new LimitExpress(this, limit);
    }

}
