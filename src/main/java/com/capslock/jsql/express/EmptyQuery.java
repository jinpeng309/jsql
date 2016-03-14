package com.capslock.jsql.express;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.type.SqlContext;

/**
 * Created by capslock.
 */
public class EmptyQuery implements SqlContext {
    @Override
    public void build(final SqlBuilder sqlBuilder) {

    }
}
