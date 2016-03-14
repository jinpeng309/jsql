package com.capslock.jsql;

import com.capslock.jsql.express.literal.StringLiteralExpress;

import static com.capslock.jsql.express.query.Query.insertInto;
import static com.capslock.jsql.express.query.Query.select;

/**
 * Created by capslock.
 */
public class App {
    private static final class Student {
        public static final StringLiteralExpress tableName =
                StringLiteralExpress.createStringLiteralExpressWithQuote("student");
        public static final StringLiteralExpress studentId =
                StringLiteralExpress.createStringLiteralExpressWithQuote("id");
        public static final StringLiteralExpress studentName =
                StringLiteralExpress.createStringLiteralExpressWithQuote("name");
    }

    public static void main(String[] args) {

        final String selectQuery = select(Student.studentId, Student.studentName)
                .from(Student.tableName)
                .where(Student.studentId.eq(2).not().or(Student.studentName.in("alvin", "jack")))
                .orderBy(Student.studentId.desc())
                .limit(10)
                .toSql();
        System.out.println(selectQuery);

        final String insertSql = insertInto(Student.tableName)
                .columns(Student.studentId, Student.studentName)
                .values(StringLiteralExpress.createStringLiteralExpressWithoutQuote("1"),
                        StringLiteralExpress.createStringLiteralExpressWithoutQuote("tom"))
                .toSql();
        System.out.println(insertSql);
    }
}
