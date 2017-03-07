package com.mpp.project.dataaccess;


import com.mpp.project.business.Person;

public interface DataAccess {
    public void savePerson(Person member);

    public Person readPerson(int userId);
}
