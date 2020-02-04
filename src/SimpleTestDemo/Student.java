package SimpleTestDemo;

public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        if(this.age < o.age){
            return 1;
        }else if(this.age > o.age){
            return -1;
        }else{
            return 0;
        }
    }
    public String name;
    public int  age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
