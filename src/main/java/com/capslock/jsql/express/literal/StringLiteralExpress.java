package com.capslock.jsql.express.literal;

/**
 * Created by capslock.
 */
public class StringLiteralExpress extends LiteralExpression<String> {
    private StringLiteralExpress(final String value) {
        super(value);
    }

    public static StringLiteralExpress getStringLiteralExpressWithWrap(final String value) {
        return new StringLiteralExpress(wrap(value));
    }

    public static StringLiteralExpress getStringLiteralExpressWithoutWrap(final String value) {
        return new StringLiteralExpress(value);
    }

    private static String wrap(final String value) {
        return "`" + value + "`";
    }
}
