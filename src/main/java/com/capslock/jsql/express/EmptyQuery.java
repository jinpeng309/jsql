package com.capslock.jsql.express;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.query.SqlContext;
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
