package com.capslock.jsql.visitor;

/**
 * Created by capslock.
 */
public interface Visitable {
    void accept(final Visitor visitor);
}
