package example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: FeiXiang
 * @Description:
 * @Date: Created in 22:17 2018-08-27
 * @Modifid By:
 */
public class Java8DistinctExample {

    public static void main(String[] args) {

        List<Student> lists = new ArrayList<>();
        Student s1 = new Student("小明", 21, 1);
        Student s2 = new Student("小红", 22, 2);
        Student s3 = new Student("小军", 23, 1);
        Student s4 = new Student("小天", 24, 1);
        Student s5 = new Student("小明", 21, 1);
        Student s6 = new Student("小军", 23, 1);
        lists.add(s1);
        lists.add(s2);
        lists.add(s3);
        lists.add(s4);
        lists.add(s5);
        lists.add(s6);
        List<Student> students = new ArrayList<>();
        students = lists.parallelStream().distinct().collect(Collectors.toList());
        System.out.println(students);
    }

}

class Student{
    private String name;

    private int age;

    private int sex;

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        int n = 31;
        n = n * 31 + this.name.hashCode();
        n = n * 31 + this.age;
        n = n * 31 + this.sex;

        return n;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Student)) {
            return false;
        }

        Student student = (Student) obj;
        return this.name.equals(student.name) && this.age == student.age
                && this.sex == student.sex;
    }
}
