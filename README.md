# jsql
a simple sql dsl

## Sample
```
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

        /**
         * SELECT `id` , `name` 
           FROM `student` 
           WHERE `id` = 2 OR `name` IN ( 'alvin' , 'jack' ) 
           ORDER BY `id` DESC 
           LIMIT 10 
         */
        final String selectQuery = select(Student.studentId, Student.studentName)
                .from(Student.tableName)
                .where(Student.studentId.eq(2).or(Student.studentName.in("alvin", "jack")))
                .orderBy(Student.studentId.desc())
                .limit(10)
                .toSql();
    }
}

```

