package com.reactivestax.business.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class LoginModelObject {


    @NotBlank(message = "UserName cannot be empty")
    @Length(min = 5 ,max = 10 ,message ="userName length has to be between 5 to 10")
    private String userName;

    @NotBlank(message = "Password cannot be empty")
    @Length(min = 5 ,max = 10 ,message ="Password length has to be between 5 to 10")

    private String password;

    @Override
    public String toString() {
        return "LoginModelObject{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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
}
