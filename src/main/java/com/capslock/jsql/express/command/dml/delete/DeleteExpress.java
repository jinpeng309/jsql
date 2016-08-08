package com.capslock.jsql.express.command.dml.delete;

import com.capslock.jsql.express.command.Command;
import com.capslock.jsql.express.command.SqlContext;
import com.capslock.jsql.type.Visitor;

/**
 * Created by capslock.
 */
public class DeleteExpress extends Command {

    public DeleteExpress(final SqlContext sqlContext) {
        super(sqlContext);
    }

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
