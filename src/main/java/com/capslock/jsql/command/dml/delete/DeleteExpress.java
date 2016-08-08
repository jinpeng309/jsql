package com.capslock.jsql.command.dml.delete;

import com.capslock.jsql.command.Command;
import com.capslock.jsql.command.SqlContext;
import com.capslock.jsql.visitor.Visitor;

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
