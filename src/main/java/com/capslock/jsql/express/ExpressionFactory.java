package com.capslock.jsql.express;

import com.capslock.jsql.express.literal.StringLiteralExpress;
import com.capslock.jsql.express.operator.Operator;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.Collection;

/**
 * Created by capslock.
 */
public class ExpressionFactory {
    public static BooleanOperationExpress booleanOperation(final Operator operator, final Express<?>... args) {
        return new BooleanOperationExpress(operator, ImmutableList.copyOf(args));
    }

    public static StringLiteralExpress stringLiteralExpressWithSeparator(final Collection<String> args, final String separator) {
        return StringLiteralExpress.getStringLiteralExpressWithoutWrap("( " + Joiner.on(" " + separator + " ").join(args) + " )");
    }

}
