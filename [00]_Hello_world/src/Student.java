import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;

    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
