package com.capslock.jsql.express.literal;

/**
 * Created by capslock.
 */
public class Column extends StringLiteral {
    public Column(final String value) {
        super("`" + value + "`");
    }
}
