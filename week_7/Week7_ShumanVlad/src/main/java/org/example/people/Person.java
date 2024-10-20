package org.example.people;

import org.example.CheckData;

public class Person
{
    private String name;

    public Person(String name) throws Exception
    {
        CheckData.checkPerson(name);
        this.name = name;
    }

    public String getName(){return this.name;}

    public void setName(String name) throws Exception
    {
        CheckData.checkPersonName(name);
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
