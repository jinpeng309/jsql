package com.capslock.jsql.express.operator;

/**
 * Created by capslock.
 */
public enum Order {
    asc(1), desc(2);

    private final int value;

    Order(final int value) {
        this.value = value;
    }
}
