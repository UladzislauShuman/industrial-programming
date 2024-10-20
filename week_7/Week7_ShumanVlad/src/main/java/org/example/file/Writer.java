package org.example.file;

import org.example.CheckData;
import org.example.people.university.course.Course;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer
{
    public static void saveCourseToFile(Course course, String fileName) throws Exception
    {
        CheckData.checkFileName(fileName);
        CheckData.checkCourse(course);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            writer.write(course.toString());
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
