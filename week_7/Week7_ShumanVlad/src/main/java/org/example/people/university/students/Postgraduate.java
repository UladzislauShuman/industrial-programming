package org.example.people.university.students;

import org.example.CheckData;
import org.example.people.university.academics.Academic;

public class Postgraduate extends Student
{
    private Academic supervisor;
    public Postgraduate(String name, String login, String email, Academic supervisor) throws Exception
    {
        super(name,login,email);
        CheckData.checkPostgraduate(name, login, email, supervisor);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor() throws Exception {return this.supervisor;}
    public void setSupervisor(Academic supervisor) throws Exception
    {
        CheckData.checkPostgraduateAcademic(supervisor);
        this.supervisor = supervisor;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.supervisor.getName();
    }
}