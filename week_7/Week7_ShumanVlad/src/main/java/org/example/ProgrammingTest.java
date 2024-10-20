package org.example;

import org.example.file.Writer;
import org.example.notifier.Notifier;
import org.example.people.university.academics.Academic;
import org.example.people.university.course.Course;
import org.example.people.university.students.Postgraduate;
import org.example.people.university.students.Student;
import org.example.people.university.students.Undergraduate;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class ProgrammingTest {
    public static void main(String[] args)
    {
        try
        {
            Academic PaulDeitel = new Academic("Paul Deitel");
            Academic CayHorstmann = new Academic("Cay Horstmann");

            Student student1 = new Undergraduate("Vlad", "gg4", "shumanvlad@gmail.com",PaulDeitel);
            Student student2 = new Undergraduate("Leha", "pr3", "leha@gmail.com",CayHorstmann);
            Student student3 = new Postgraduate("Anton", "te2", "anton@gmail.com",PaulDeitel);
            Student student4 = new Postgraduate("Sergey", "yj34", "sergey@gmail.com",CayHorstmann);
            Student student5 = new Postgraduate("Shen", "jj8", "shen@gmail.com",CayHorstmann);

            Course course = new Course(
                    "indastrial-programming",
                    new HashSet<Student>(
                            Set.of(
                                    student1,
                                    student2,
                                    student3,
                                    student4,
                                    student5
                            )
                    )
            );
            System.out.println(course.getPostgraduates(CayHorstmann.getName()).toString());

            Notifier notifier = new Notifier(
                    new HashSet<Student>(
                            Set.of(
                                    student1,
                                    student2,
                                    student3,
                                    student4,
                                    student5
                            )
                    )
            );
            notifier.doNotifyAll("Hello, Students!");

            Predicate<Student> namePredicate = student -> student.getName() == "Vlad";
            Set<Student> res = course.getPredicate(namePredicate);
            System.out.println(res.toString());

            Writer.saveCourseToFile(course,"output.txt");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}