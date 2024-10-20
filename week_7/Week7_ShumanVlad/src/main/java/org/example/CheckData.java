package org.example;

import org.example.people.university.academics.Academic;
import org.example.people.university.course.Course;
import org.example.people.university.students.Student;

import java.util.Set;

public class CheckData
{
    public static void checkPerson(String name) throws Exception
    {
        CheckData.checkPersonName(name);
    }
    public static void checkPersonName(String name) throws Exception
    {
        if (name.isEmpty())
            throw new Exception("No name person");
    }

    public static void checkStudent(String name, String login, String email) throws Exception
    {
        CheckData.checkPerson(name);
        CheckData.checkStudentLogin(login);
        CheckData.checkStudentEmail(email);
    }
    public static void checkStudent(Student student) throws Exception
    {
        if (student == null)
            throw new Exception("student == null");
    }
    public static void checkStudentLogin(String login) throws Exception
    {
        if (login.isEmpty())
            throw new Exception("empty student login");
    }
    public static void checkStudentEmail(String email) throws Exception
    {
        if(email.isEmpty())
            throw new Exception("empty student email");
    }

    public static void checkUndergraduate(String name, String login, String email, Academic tutor) throws Exception
    {
        CheckData.checkStudent(name, login, email);
        CheckData.checkUndergraduateAcademic(tutor);
    }
    //пока не придумал
    public static void checkPostgraduateAcademic(Academic supervisor) throws Exception
    {
        return;
    }

    public static void checkPostgraduate(String name, String login, String email, Academic supervisor) throws Exception
    {
        CheckData.checkStudent(name, login, email);
        CheckData.checkUndergraduateAcademic(supervisor);
    }
    //пока не придумал
    public static void checkUndergraduateAcademic(Academic supervisor) throws Exception
    {
        return;
    }

    public static void checkCourse(String name, Set<Student> students) throws Exception
    {
        CheckData.checkCourseName(name);
        CheckData.checkCourseStudents(students);
    }
    public static void checkCourse(Course course) throws Exception
    {
        if (course == null)
            throw new Exception("course == null");
    }
    public static void checkCourseName(String name) throws Exception
    {
        if (name.isEmpty())
            throw new Exception("No name course");
    }
    public static void checkCourseStudents(Set<Student> students) throws Exception
    {
        if (students == null)
            throw new Exception("students == null");
    }

    public static void checkFileName(String fileName) throws Exception
    {
        CheckData.checkFileNameIsEmpty(fileName);
        CheckData.checkFileNameFormat(fileName);
    }
    public static void checkFileNameIsEmpty(String fileName) throws Exception
    {
        if (fileName.isEmpty())
            throw new Exception("Empty file name");
    }
    public static void checkFileNameFormat(String fileName) throws Exception
    {
        if (!fileName.endsWith(".txt"))
            throw new Exception(fileName + " is not txt");
    }

}
