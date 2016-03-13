package com.capslock.jsql;

import com.capslock.jsql.express.literal.StringLiteralExpress;

/**
 * Created by capslock.
 */
public class App {
    public static void main(String[] args) {
        final SqlBuilder serializer = new SqlBuilder();
        final StringLiteralExpress studentId = StringLiteralExpress.getStringLiteralExpressWithWrap("id");
        final StringLiteralExpress studentName = StringLiteralExpress.getStringLiteralExpressWithWrap("name");
        final StringLiteralExpress studentTable = StringLiteralExpress.getStringLiteralExpressWithWrap("student");
        final Query query = new Query(serializer);
        final String sql = query
                .select(studentId, studentName)
                .from(studentTable, studentTable)
                .where(studentId.eq(2).and(studentId.eq(3.2)).or(studentName.in("alvin","jack")).and(studentId.in(1,2,3)))
                .toSql();
        System.out.println(sql);
    }
}
