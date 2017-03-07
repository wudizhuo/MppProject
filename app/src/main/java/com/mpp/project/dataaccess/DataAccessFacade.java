package com.mpp.project.dataaccess;

import com.mpp.project.App;
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

    public void savePerson(String name, Person member) {
        File file = new File(getDataDir(), name);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileStorageUtil.writeObject(file, member);
    }

    public Person readPerson(String name) {
        File file = new File(getDataDir(), name);
        return (Person) FileStorageUtil.readObject(file);
    }

}
