package com.capslock.jsql.express.command.dml.update;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.booleanExpress.Predicate;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.command.Command;
import com.capslock.jsql.express.command.SqlContext;
import com.capslock.jsql.express.command.dml.select.WhereExpress;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class FollowSetExpress extends Command {
    private final Express column;
    private final Express value;

    public FollowSetExpress(final SqlContext sqlContext, final Express column, final Express value) {
        super(sqlContext);
        this.column = column;
        this.value = value;
    }

    public WhereExpress where(final Predicate condition) {
        return new WhereExpress(this, condition);
    }

    public FollowSetExpress set(final Express column, final String value) {
        return new FollowSetExpress(this, column, StringLiteral.createWithApostrophe(value));
    }

    public <T extends Number> FollowSetExpress set(final Express column, final T value){
        return new FollowSetExpress(this, column, StringLiteral.create(value));
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public Express getColumn() {
        return column;
    }

    public Express getValue() {
        return value;
    }
}
