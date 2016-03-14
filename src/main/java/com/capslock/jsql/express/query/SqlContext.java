package com.capslock.jsql.express.query;

import com.capslock.jsql.SqlBuilder;
import com.capslock.jsql.express.Express;

/**
 * Created by capslock.
 */
public interface SqlContext extends Express {
    void build(final SqlBuilder sqlBuilder);
}
