package com.capslock.jsql.express;

import com.capslock.jsql.express.booleanExpress.BooleanOperationExpress;
import com.capslock.jsql.express.literal.StringLiteral;
import com.capslock.jsql.express.operator.Operator;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Set;

/**
 * Created by capslock.
 */
public class ExpressionFactory {
    public static BooleanOperationExpress booleanOperation(final Operator operator, final Express<?>... args) {
        return new BooleanOperationExpress(operator, ImmutableList.copyOf(args));
    }

    public static StringLiteral stringLiteralExpressWithSeparator(final Collection<String> args, final String separator) {
        return StringLiteral.create("( " + Joiner.on(" " + separator + " ").join(args) + " )");
    }

    public static <N extends Set<? extends Number>> StringLiteral stringLiteralExpressWithSeparator(final N args, final String separator) {
        return StringLiteral.create("( " + Joiner.on(" " + separator + " ").join(args) + " )");
    }

}
