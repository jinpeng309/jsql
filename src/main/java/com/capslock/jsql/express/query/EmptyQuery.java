package com.capslock.jsql.express.query;

import com.capslock.jsql.type.SqlBuilder;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class EmptyQuery implements SqlContext {
    @Override
    public void accept(final Visitor visitor) {

    }

    @Override
    public void build(final SqlBuilder sqlBuilder) {

    }
}
