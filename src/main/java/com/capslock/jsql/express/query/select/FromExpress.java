package com.capslock.jsql.express.query.select;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.booleanExpress.Predicate;
import com.capslock.jsql.express.booleanExpress.PredicateOperation;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by capslock.
 */
public class FromExpress extends Query implements Express {
    private final List<Express<?>> tableExpressList;

    public FromExpress(final SqlContext sqlContext, final Express<?> table) {
        super(sqlContext);
        this.tableExpressList = ImmutableList.<Express<?>>of(table);
    }

    public FromExpress(final SqlContext sqlContext, final Express<?>... tables) {
        super(sqlContext);
        this.tableExpressList = ImmutableList.copyOf(tables);
    }

    public WhereExpress where(final Predicate condition) {
        return new WhereExpress(this, condition);
    }

    public WhereExpress exists(final SelectExpress selectExpress) {
        final Predicate predicate = new PredicateOperation(Operators.EXISTS, ImmutableList.<Express<?>>of(selectExpress));
        return new WhereExpress(this, predicate);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public List<Express<?>> getFromTableExpressList() {
        return tableExpressList;
    }
}
