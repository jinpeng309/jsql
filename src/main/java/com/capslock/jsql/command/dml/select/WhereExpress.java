package com.capslock.jsql.command.dml.select;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.command.dml.select.order.OrderByExpress;
import com.capslock.jsql.command.dml.select.order.OrderExpress;
import com.capslock.jsql.visitor.Visitor;

/**
 * Created by capslock.
 */
public class WhereExpress extends Command implements Express {
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
