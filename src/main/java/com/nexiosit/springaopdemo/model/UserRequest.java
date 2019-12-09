package com.nexiosit.springaopdemo.model;

public class UserRequest {

    private String firstName;
    private String lastName;

    public UserRequest(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
