package com.l4g.overriden_methods;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person guest = (Person) obj;
        return id == guest.id
                && (firstName == guest.firstName
                || (firstName != null &&firstName.equals(guest.getFirstName())))
                && (lastName == guest.lastName
                || (lastName != null && lastName .equals(guest.getLastName())
        ));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());             result = prime * result + id; result = prime * result +
                ((lastName == null) ? 0 : lastName.hashCode()); return result;
    }

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person(1, "Donald", null));
        System.out.println(people.contains(new Person(1, "Donald", null)));
    }
}
