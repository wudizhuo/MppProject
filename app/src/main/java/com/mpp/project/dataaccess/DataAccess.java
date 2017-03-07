package com.mpp.project.dataaccess;


import com.mpp.project.business.Person;

public interface DataAccess {
    public void savePerson(String name, Person member);

    public Person readPerson(String name);
}
