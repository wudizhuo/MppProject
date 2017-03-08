package com.mpp.project.dataaccess;


import com.mpp.project.business.Book;
import com.mpp.project.business.Person;

public interface DataAccess {
    public void savePerson(Person member);

    public Person readPerson(int userId);

    public void saveBook(Book book);

    public Book queryBook(int ISBN);
}
