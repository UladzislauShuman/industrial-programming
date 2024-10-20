package org.example.people.university.students;

import org.example.CheckData;
import org.example.notifier.Notifiable;
import org.example.people.Person;

public abstract class Student extends Person implements Notifiable
{
    private String login;
    private String email;

    public Student(String name, String login, String email) throws Exception
    {
        super(name);
        //name is useless here
        CheckData.checkStudent(name, login, email);
        this.login = login;
        this.email = email;
    }

    public String getLogin() {return this.login;}
    public String getEmail() {return this.email;}

    public void setLogin(String login) throws Exception
    {
        CheckData.checkStudentLogin(login);
        this.login = login;
    }
    public void setEmail(String email) throws Exception
    {
        CheckData.checkStudentEmail(email);
        this.email = email;
    }

    @Override
    public void notify(String message)
    {
        System.out.println(this.getName() + " : " + message);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.login + " " +
                this.email;
    }

}
