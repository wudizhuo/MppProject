package com.mpp.project.dataaccess;

import com.mpp.project.business.Person;

import java.io.File;


public class DataAccessFacade implements DataAccess {
    public static final String OUTPUT_DIR = "";

    public void savePerson(String name, Person member) {
        FileStorageUtil.writeObject(new File(name), member);
    }

    public Person readPerson(String name) {
        return (Person) FileStorageUtil.readObject(new File(name));
    }

}
