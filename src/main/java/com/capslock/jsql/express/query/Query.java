package com.capslock.jsql.express.query;

import com.capslock.jsql.type.SqlBuilder;
import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.query.insert.InsertIntoExpress;
import com.capslock.jsql.express.query.select.SelectExpress;

/**
 * Created by capslock.
 */
public abstract class Query implements SqlContext {
    protected final SqlContext sqlContext;

    public Query(final SqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    public static SelectExpress select(final Express<?>... args) {
        return new SelectExpress(new EmptyQuery(), args);
    }

    public static InsertIntoExpress insertInto(final Express<?> tableName) {
        return new InsertIntoExpress(new EmptyQuery(), tableName);
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
