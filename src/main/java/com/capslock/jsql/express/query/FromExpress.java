package com.capslock.jsql.express.query;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.Predicate;
import com.capslock.jsql.type.Visitor;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by capslock.
 */
public class FromExpress extends Query implements Express {
    private final List<Express<?>> tableExpressList;

    public FromExpress(final SqlBuilder sqlBuilder, final Express<?> table) {
        super(sqlBuilder);
        this.tableExpressList = ImmutableList.<Express<?>>of(table);
    }

    public FromExpress(final SqlBuilder sqlBuilder, final Express<?>... tables) {
        super(sqlBuilder);
        this.tableExpressList = ImmutableList.copyOf(tables);
    }


    public WhereExpress where(final Predicate condition) {
        final WhereExpress whereExpress = new WhereExpress(sqlBuilder, condition);
        whereExpress.accept(sqlBuilder);
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
