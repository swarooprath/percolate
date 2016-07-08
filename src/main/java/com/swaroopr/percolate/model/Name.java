package com.swaroopr.percolate.model;

/**
 * Wrapper class for firstName and lastName.
 * Created by sr on 7/5/16.
 */
public class Name implements Comparable<Name>{

    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Name o) {
        int val = this.lastName.compareTo(o.lastName);
        return (val != 0) ? val : this.firstName.compareTo(o.firstName);
    }
}
