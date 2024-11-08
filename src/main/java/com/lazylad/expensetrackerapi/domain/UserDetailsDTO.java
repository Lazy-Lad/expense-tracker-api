package com.lazylad.expensetrackerapi.domain;

public class UserDetailsDTO {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;

    public UserDetailsDTO(String email, String lastName, String firstName, Integer userId) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
