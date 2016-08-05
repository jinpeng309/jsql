package com.capslock.jsql.express.literal;

/**
 * Created by capslock.
 */
public class Table extends StringLiteral {
    public Table(final String value) {
        super("`" + value + "`");
    }
}