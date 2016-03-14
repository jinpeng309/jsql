package com.capslock.jsql.express.query;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.EmptyQuery;
import com.capslock.jsql.express.Express;

/**
 * Created by capslock.
 */
public abstract class Query implements SqlContext, Express {
    protected final SqlContext sqlContext;

    public Query(final SqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    public static SelectExpress select(final Express<?>... args) {
        return new SelectExpress(new EmptyQuery(), args);
    }

    @Override
    public void build(final SqlBuilder sqlBuilder) {
        sqlContext.build(sqlBuilder);
        this.accept(sqlBuilder);
    }

    public String toSql() {
        final SqlBuilder sqlBuilder = new SqlBuilder();
        build(sqlBuilder);
        return sqlBuilder.build();
    }
}
