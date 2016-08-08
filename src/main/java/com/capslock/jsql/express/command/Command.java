package com.capslock.jsql.express.command;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.command.dml.delete.DeleteExpress;
import com.capslock.jsql.express.command.dml.insert.InsertExpress;
import com.capslock.jsql.express.command.dml.select.FromExpress;
import com.capslock.jsql.express.command.dml.select.SelectExpress;
import com.capslock.jsql.express.command.dml.update.UpdateExpress;
import com.capslock.jsql.type.SqlBuilder;

/**
 * Created by capslock.
 */
public abstract class Command implements SqlContext {
    protected final SqlContext sqlContext;

    public Command(final SqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    public static SelectExpress select(final Express<?>... args) {
        return new SelectExpress(new EmptyCommand(), args);
    }

    public static InsertExpress insertInto(final Express<?> tableName) {
        return new InsertExpress(new EmptyCommand(), tableName, "INSERT INTO");
    }

    public static InsertExpress insertOrReplaceInto(final Express<?> tableName) {
        return new InsertExpress(new EmptyCommand(), tableName, "INSERT OR REPLACE INTO");
    }

    public static InsertExpress insertIgnoreInto(final Express<?> tableName) {
        return new InsertExpress(new EmptyCommand(), tableName, "INSERT IGNORE INTO");
    }

    public static FromExpress delete(final Express<?> tableName) {
        return new FromExpress(new DeleteExpress(new EmptyCommand()), tableName);
    }

    public static UpdateExpress update(final Express<?> tableName){
        return new UpdateExpress(new EmptyCommand(), tableName);
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
