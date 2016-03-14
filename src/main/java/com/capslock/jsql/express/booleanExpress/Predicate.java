package com.capslock.jsql.express.booleanExpress;

import com.capslock.jsql.express.Express;

/**
 * Created by capslock.
 */
public interface Predicate extends Express<Boolean> {
    Predicate not();
}
