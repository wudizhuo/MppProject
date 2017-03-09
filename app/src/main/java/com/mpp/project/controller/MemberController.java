package com.mpp.project.controller;

import com.mpp.project.business.Admin;
import com.mpp.project.business.AdminRole;
import com.mpp.project.business.Librarian;
import com.mpp.project.business.LibraryMember;
import com.mpp.project.business.Person;

import java.util.HashMap;

/**
 * Created by prageeth on 3/8/17.
 */

public final class MemberController {

    // When this method get call, it should call on the instance associated with the AdminRole
    public String addLibraryMember(Person executor, HashMap<String, String> memberDetails) throws Exception{
        String result = "";
        if(executor instanceof Admin) {
            Admin admin = (Admin) executor;
            //result = admin.add(admin.level, memberDetails); // Add an admin user like this
            result = admin.add(null, memberDetails);
        } else if(executor instanceof Librarian){
            Librarian librarian = (Librarian) executor;
            if(librarian.getRole() instanceof AdminRole){
                Admin admin = (Admin)librarian.getRole(); //This instance is associated with admin object
                //result = admin.add(admin.level, memberDetails); // A librarian with admin role can add an admin user like this
                result = admin.add(null, memberDetails);
            }
        } else {
            throw new IllegalAccessException("You cannot access this feature");
        }

        return result;
    }

    public LibraryMember updateLibraryMember(String libraryMemberId){
        return null; //TODO: Search by the id and update the member, if not found throw an exception
    }
}
