package com.mpp.project.business;

import java.io.Serializable;

/**
 * Created by prageeth on 3/6/17.
 */

public class Address implements Serializable {
    private String street;
    private String city;
    private String zip;
    private String state;
    private String country;

    public Address(String street, String city, String state, String zip, String country) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
