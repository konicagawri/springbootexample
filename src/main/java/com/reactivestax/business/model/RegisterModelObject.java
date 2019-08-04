package com.reactivestax.business.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class RegisterModelObject {

    @NotBlank(message = "UserName cannot be empty")
    @Length(min = 5 ,max = 10 ,message ="userName length has to be between 5 to 10")
    private String userName;

    @NotBlank(message = "Password cannot be empty")
    @Length(min = 5 ,max = 10 ,message ="userName length has to be between 5 to 10")
    private String password;

    @NotBlank(message = "FirstName cannot be empty")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    private int phoneNo;

    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RegisterModelObject{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

