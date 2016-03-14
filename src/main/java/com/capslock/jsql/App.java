package com.capslock.jsql;

import com.capslock.jsql.express.literal.StringLiteralExpress;
import com.capslock.jsql.express.query.Query;

/**
 * Created by capslock.
 */
public class App {
    public static void main(String[] args) {
        final StringLiteralExpress studentId = StringLiteralExpress.createStringLiteralExpressWithQuote("id");
        final StringLiteralExpress studentName = StringLiteralExpress.createStringLiteralExpressWithQuote("name");
        final StringLiteralExpress studentTable = StringLiteralExpress.createStringLiteralExpressWithQuote("student");
        final String sql = Query.select(studentId, studentName)
                .from(studentTable, studentTable)
                .where(studentId.eq(2).not().and(studentId.eq(3.2)).or(studentName.in("alvin", "jack")).and(studentId.in(1, 2, 3)))
                .orderBy(studentId.asc())
                .toSql();
        System.out.println(sql);
    }
}
