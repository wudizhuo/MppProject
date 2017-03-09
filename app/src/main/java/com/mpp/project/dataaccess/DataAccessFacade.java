package com.mpp.project.dataaccess;

import com.mpp.project.App;
import com.mpp.project.business.Book;
import com.mpp.project.business.Person;

import java.io.File;


public class DataAccessFacade implements DataAccess {
    public static final String OUTPUT_DIR = "MppProject";

    public File getDataDir() {
        File result = new File(
                App.getContext().getExternalFilesDir(null),
                OUTPUT_DIR);
        if (!result.exists()) {
            result.mkdirs();
        }
        return result;
    }

    public void savePerson(Person person) {
        File file = new File(getDataDir(), "person" + person.getUserId());
        FileStorageUtil.writeObject(file, person);
    }

    public Person readPerson(int useId) {
        File file = new File(getDataDir(), "person" + useId);
        return (Person) FileStorageUtil.readObject(file);
    }

    @Override
    public void saveBook(Book book) {
        File file = new File(getDataDir(), "book" + book.getIsbn());
        FileStorageUtil.writeObject(file, book);
    }

    @Override
    public Book queryBook(String ISBN) {
        File file = new File(getDataDir(), "book" + ISBN);
        return (Book) FileStorageUtil.readObject(file);
    }
}
