package org.ShumanVlad;

import java.util.HashSet;

public class HashSetUtil {

    /* Inner class Person simply has two name fields fn, first name and ln, last name,
       a constructor and the toString method override */
    static class Person {
        private String fn;
        private String ln;

        public Person(String fn, String ln) {
            this.fn = fn;
            this.ln = ln;
        }

        @Override
        public String toString() {
            return ln + ", " + fn;
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
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Person person = (Person) obj;

            if (fn != null ? !fn.equals(person.fn) : person.fn != null) return false;
            return ln != null ? ln.equals(person.ln) : person.ln == null;
        }
    }

    public static boolean check(String s1, String s2) {
        Person p1 = new Person(s1, s2);
        Person p2 = new Person(s1, s2);

        HashSet<Person> people = new HashSet<>();
        people.add(p1);

        return processSet(people, p2);
    }

    public static boolean processSet(HashSet<Person> people, Person person) {
        return people.contains(person);
    }
}
