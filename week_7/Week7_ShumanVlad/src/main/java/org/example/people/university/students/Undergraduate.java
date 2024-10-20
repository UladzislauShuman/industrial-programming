package org.example.people.university.students;

import org.example.CheckData;
import org.example.people.university.academics.Academic;

public class Undergraduate extends Student
{
    private Academic tutor;
    public Undergraduate(String name, String login, String email, Academic tutor) throws Exception
    {
        super(name,login,email);
        CheckData.checkUndergraduate(name, login, email, tutor);
        this.tutor = tutor;
    }

    public Academic getTutor() throws Exception {return this.tutor;}
    public void setTutor(Academic tutor) throws Exception
    {
        CheckData.checkUndergraduateAcademic(tutor);
        this.tutor = tutor;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +
                this.tutor.getName();
    }
}
