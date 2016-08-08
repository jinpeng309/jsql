package com.capslock.jsql.command;

import com.capslock.jsql.visitor.SqlBuilder;
import com.capslock.jsql.visitor.Visitor;

/**
 * Created by capslock.
 */
public class EmptyCommand implements SqlContext {
    @Override
    public void accept(final Visitor visitor) {

    }

    @Override
    public void build(final SqlBuilder sqlBuilder) {

    }
}
