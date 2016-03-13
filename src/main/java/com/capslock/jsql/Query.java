package com.capslock.jsql;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.type.Sqlable;

/**
 * Created by capslock.
 */
public class Query implements Sqlable {
    protected final SqlBuilder sqlBuilder;

    public Query(final SqlBuilder visitor) {
        this.sqlBuilder = visitor;
    }

    public SelectExpress select(final Express<?> arg) {
        final SelectExpress selectExpress = new SelectExpress(sqlBuilder, arg);
        selectExpress.accept(sqlBuilder);
        return selectExpress;
    }

    public SelectExpress select(final Express<?>... args) {
        final SelectExpress selectExpress = new SelectExpress(sqlBuilder, args);
        selectExpress.accept(sqlBuilder);
        return selectExpress;
    }

    @Override
    public String toSql() {
        return sqlBuilder.build().trim();
    }
}
