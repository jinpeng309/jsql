package com.capslock.jsql.express;

import com.capslock.jsql.express.booleanExpress.BooleanOperationExpress;
import com.capslock.jsql.express.literal.StringLiteral;
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

    public static <N> StringLiteral stringLiteralExpressWithSeparator(final Collection<N> args, final String separator) {
        return StringLiteral.create("( " + Joiner.on(" " + separator + " ").join(args) + " )");
    }

}
