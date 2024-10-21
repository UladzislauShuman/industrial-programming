package Humans;

public class Student
{
    private String name;
    private int age;

    public Student(String name, int age)
    {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String toString()
    {
        return "Student {" +
                "name " + this.name +
                "age " + this.age +
                "}\n";
    }
}
