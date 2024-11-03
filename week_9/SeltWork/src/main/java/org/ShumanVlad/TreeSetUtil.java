package org.ShumanVlad;

import java.util.TreeSet;

/**
 * This TreeSetUtil class tests various usages of the TreeSetUtil class.
 * params 1 is an array of strings. param2 is a single string. This program will create
 * a TreeSet made of Person object. Person is an inner class. This program will fail to
 * run as any TreeSet element MUST implement the Comparable interface. You will need to
 * implement that interface for the type to make the program run correctly.
 */
public class TreeSetUtil {

    public static boolean check(String[] names, String searchName) {
        TreeSet<Person> people = new TreeSet<>();
        for (String name : names) {
            people.add(new Person(name, ""));
        }

        Person searchPerson = new Person(searchName, "");

        return people.contains(searchPerson);
    }

    /* Inner class Person simply has two name fields fn, first name and ln, last name,
       a constructor and the toString method override
    */
    static class Person implements Comparable<Person> {
        private String fn;
        private String ln;

        public Person(String fn, String ln) {
            this.fn = fn;
            this.ln = ln;
        }

        @Override
        public String toString() {
            return ln.isEmpty() ? fn : ln + ", " + fn;
        }

        // Overriding hashCode method
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (fn == null ? 0 : fn.hashCode());
            result = 31 * result + (ln == null ? 0 : ln.hashCode());
            return result;
        }

        // Overriding equals method
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Person person = (Person) obj;

            if (fn != null ? !fn.equals(person.fn) : person.fn != null) return false;
            return ln != null ? ln.equals(person.ln) : person.ln == null;
        }

        // Implementing compareTo method
        @Override
        public int compareTo(Person other) {
            return this.fn.compareTo(other.fn);
        }
    }
}
