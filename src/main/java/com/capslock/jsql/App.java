package com.capslock.jsql;

import com.capslock.jsql.express.Express;
import com.capslock.jsql.express.literal.StringLiteral;

import java.util.ArrayList;
import java.util.List;

import static com.capslock.jsql.express.query.Query.insertInto;
import static com.capslock.jsql.express.query.Query.select;

/**
 * Created by capslock.
 */
public class App {
    private static final class Student {
        public static final StringLiteral tableName =
                StringLiteral.createWithGraveAccent("student");
        public static final StringLiteral studentId =
                StringLiteral.createWithGraveAccent("id");
        public static final StringLiteral studentName =
                StringLiteral.createWithGraveAccent("name");
    }

    public static void main(String[] args) {

        final String selectQuery = select(Student.studentId, Student.studentName)
                .from(Student.tableName)
                .where(Student.studentId.eq(2).not().or(Student.studentName.in("alvin", "jack")))
                .orderBy(Student.studentId.desc())
                .limit(10)
                .toSql();
        System.out.println(selectQuery);

        final List<Express> value1 = new ArrayList<>();
        value1.add(StringLiteral.create(1));
        value1.add(StringLiteral.createWithApostrophe("jack"));

        final List<Express> value2 = new ArrayList<>();
        value2.add(StringLiteral.create(2));
        value2.add(StringLiteral.createWithApostrophe("alvin"));

        final String insertSql = insertInto(Student.tableName)
                .columns(Student.studentId, Student.studentName)
                .select(select(Student.studentId, Student.studentName)
                        .from(Student.tableName)
                        .where(Student.studentId.eq(2).not().or(Student.studentName.in("alvin", "jack")))
                        .orderBy(Student.studentId.desc())
                        .limit(10).toSql())
                .toSql();
        System.out.println(insertSql);
    }
}
