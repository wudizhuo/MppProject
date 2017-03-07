package com.mpp.project.business;

import java.io.Serializable;

/**
 * Created by prageeth on 3/7/17.
 */

public class Person implements Serializable{

    private static final long serialVersionUID = 1L;
    private int userId;
    private String firstName;
    private String lastName;
    private String passWord;
    private String phoneNo;
    private Address address;

    public Person(int userId, String firstName, String lastName, String passWord, String phoneNo, Address address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public Address getAddress() {
        return address;
    }
    public String getPassWord() {
        return passWord;
    }
}
