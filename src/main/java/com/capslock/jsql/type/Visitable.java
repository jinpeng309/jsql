package com.capslock.jsql.type;

/**
 * Created by capslock.
 */
public interface Visitable {
    void accept(final Visitor visitor);
}
