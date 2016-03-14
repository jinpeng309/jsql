package com.capslock.jsql.type;

import com.capslock.jsql.SqlBuilder;

/**
 * Created by capslock.
 */
public interface SqlContext {
    void build(final SqlBuilder sqlBuilder);
}
