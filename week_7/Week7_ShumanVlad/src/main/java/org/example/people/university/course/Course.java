package org.example.people.university.course;

import org.example.CheckData;
import org.example.people.university.students.Postgraduate;
import org.example.people.university.students.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Course implements Iterable<Student>
{
    private Set<Student> students;
    private String name;

    public Course(String name, Set<Student> students) throws Exception
    {
        CheckData.checkCourse(name, students);
        this.name = name;
        this.students = new HashSet<Student>();
        this.students.addAll(students);
    }

    public void printStudents()
    {
        System.out.println(this.students);
    }

    public Set<Postgraduate> getPostgraduates(String NameOfSupervisor) throws Exception
    {
        Set<Postgraduate> postgraduates = new HashSet<>();
        for (Student student : this.students)
        {
            if (student instanceof Postgraduate)
            {
                Postgraduate postgraduate = (Postgraduate) student;
                if (postgraduate.getSupervisor().getName().equals(NameOfSupervisor))
                {
                    postgraduates.add(postgraduate);
                }
            }
        }
        return postgraduates;
    }

    public void addStudent(Student student) throws Exception
    {
        CheckData.checkStudent(student);
        this.students.add(student);
    }

    @Override
    public String toString()
    {
        String res = "";
        for (Student student : this.students)
        {
            res += student.toString() + "\n";
        }
        return res;
    }

    @Override
    public Iterator<Student> iterator()
    {
        return students.iterator();
    }

    public Set<Student> getPredicate(Predicate<Student> predicate)
    {
        Set<Student> result = new HashSet<>();
        Iterator<Student> iterator = this.students.iterator();
        while (iterator.hasNext())
        {
            Student student = iterator.next();
            if (predicate.test(student))
            {
                result.add(student);
            }
        }
        return result;
    }
}
