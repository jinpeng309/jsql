package com.capslock.jsql.express.query;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.query.delete.DeleteExpress;
import com.capslock.jsql.express.query.insert.InsertExpress;
import com.capslock.jsql.express.query.select.FromExpress;
import com.capslock.jsql.express.query.select.SelectExpress;
import com.capslock.jsql.express.query.update.UpdateExpress;
import com.capslock.jsql.type.SqlBuilder;

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

    public static InsertExpress insertInto(final Express<?> tableName) {
        return new InsertExpress(new EmptyQuery(), tableName, "INSERT INTO");
    }

    public static InsertExpress insertIgnoreInto(final Express<?> tableName) {
        return new InsertExpress(new EmptyQuery(), tableName, "INSERT IGNORE INTO");
    }

    public static FromExpress delete(final Express<?> tableName) {
        return new FromExpress(new DeleteExpress(new EmptyQuery()), tableName);
    }

    public static UpdateExpress update(final Express<?> tableName){
        return new UpdateExpress(new EmptyQuery(), tableName);
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
