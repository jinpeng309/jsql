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
        
                final List<Express> value1 = new ArrayList<>();
                value1.add(StringLiteral.create(1));
                value1.add(StringLiteral.createWithApostrophe("jack"));
        
                final List<Express> value2 = new ArrayList<>();
                value2.add(StringLiteral.create(2));
                value2.add(StringLiteral.createWithApostrophe("alvin"));
        
        
                /**
                 * INSERT INTO`student`  (`id` , `name`)  VALUES (1 , 'jack') , (2 , 'alvin')
                 */
                final String insertSql = insertInto(Student.tableName)
                        .columns(Student.studentId, Student.studentName)
                        .values(value1, value2)
                        .toSql();
        
                /**
                 * DELETE
                 FROM `student`
                 WHERE `id` = 2
                 LIMIT 10
                 */
                final String deleteSql = delete(Student.tableName)
                        .where(Student.studentId.eq("2"))
                        .limit(10).toSql();
        
        
                /**
                 * UPDATE `student`
                 SET `name`='alvin' , `id`=1
                 WHERE `id` IN ( 1 , 2 , 3 )
                 LIMIT 10
                 */
                final String updateSql = update(Student.tableName)
                        .set(Student.studentName, "alvin")
                        .set(Student.studentId, 1)
                        .where(Student.studentId.in(1, 2, 3))
                        .limit(10)
                        .toSql();
    }
}

```

