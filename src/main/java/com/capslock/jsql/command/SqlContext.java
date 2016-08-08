package com.capslock.jsql.command;

import com.capslock.jsql.visitor.SqlBuilder;
import com.capslock.jsql.express.Express;

/**
 * Created by capslock.
 */
public interface SqlContext extends Express {
    void build(final SqlBuilder sqlBuilder);
}
