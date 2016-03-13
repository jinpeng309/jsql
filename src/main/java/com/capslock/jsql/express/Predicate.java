package com.capslock.jsql.express;

/**
 * Created by capslock.
 */
public interface Predicate extends Express<Boolean> {
    Predicate not();
}
