package com.capslock.jsql.express.literal;

/**
 * Created by capslock.
 */
public class StringLiteral extends LiteralExpression<String> {
    private StringLiteral(final String value) {
        super(value);
    }

    public static StringLiteral createWithQuote(final String value) {
        return new StringLiteral("`" + value + "`");
    }

    public static StringLiteral createWithApostrophe(final String value) {
        return new StringLiteral("'" + value + "'");
    }

    public static StringLiteral create(final String value) {
        return new StringLiteral(value);
    }

    public static <T extends Number> StringLiteral create(final T value) {
        return create(value.toString());
    }
}
