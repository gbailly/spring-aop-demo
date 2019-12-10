package com.nexiosit.springaopdemo.model;

public class UserResponse {

    private int id;
    private String firstName;
    private String lastName;

    public UserResponse(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("UserResponse{id=%d, firstName='%s', lastName='%s'}", id, firstName, lastName);
    }
}
