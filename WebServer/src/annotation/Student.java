package annotation;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 17:41
 * @Description:
 */
@table("student")
public class Student {
    @MyFieldAnnotation(columnName = "id",type = "int",length = 10)
    private int id;
    @MyFieldAnnotation(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @MyFieldAnnotation(columnName = "age",type = "int",length = 3)
    private int age;
    public int getId() {
        return id;
    }

    public Student() {
    }

    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}