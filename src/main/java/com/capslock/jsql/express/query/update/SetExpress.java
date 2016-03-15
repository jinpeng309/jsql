package com.capslock.jsql.express.query.update;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.booleanExpress.Predicate;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.query.Query;
import com.capslock.jsql.express.query.SqlContext;
import com.capslock.jsql.express.query.select.WhereExpress;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class SetExpress extends Query {
    private final Express column;
    private final Express value;

    public SetExpress(final SqlContext sqlContext, final Express column, final Express value) {
        super(sqlContext);
        this.column = column;
        this.value = value;
    }

    public WhereExpress where(final Predicate condition) {
        return new WhereExpress(this, condition);
    }

    public Express getColumn() {
        return column;
    }

    public Express getValue() {
        return value;
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
}