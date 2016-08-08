package com.capslock.jsql.express.command;

import com.capslock.jsql.type.SqlBuilder;
import com.capslock.jsql.express.Express;

/**
 * Created by capslock.
 */
public interface SqlContext extends Express {
    void build(final SqlBuilder sqlBuilder);
}
