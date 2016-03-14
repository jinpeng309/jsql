package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.Predicate;
import com.capslock.jsql.express.PredicateOperation;
import com.capslock.jsql.express.operator.Operators;
import com.capslock.jsql.type.SqlContext;
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
        final WhereExpress whereExpress = new WhereExpress(this, condition);
        return whereExpress;
    }

    public WhereExpress exists(final SelectExpress selectExpress) {
        final Predicate predicate = new PredicateOperation(Operators.EXISTS, ImmutableList.<Express<?>>of(selectExpress));
        final WhereExpress whereExpress = new WhereExpress(this, predicate);
        return whereExpress;
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public List<Express<?>> getFromTableExpressList() {
        return tableExpressList;
    }
}
