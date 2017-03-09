package com.mpp.project.business;

import com.mpp.project.dataaccess.DataAccessFacade;

import java.util.HashMap;

/**
 * Created by prageeth on 3/7/17.
 */

public final class Admin extends Person implements AdminRole {
    private IRole role;

    @Override
    public AuthorizationLevel getAuthorizationLevel() {
        return AuthorizationLevel.ADMIN;
    }

    public Admin(int userId, String firstName, String lastName, String passWord, String phoneNo) {
        super(userId, firstName, lastName, passWord, phoneNo);
    }

    @Override
    public String add(Object item) {
        // Template design pattern can be used here
        if(item instanceof Book){
            // TODO: Check the object structure to create before adding a book into the system
        } else if(item instanceof Author){

        } else if(item instanceof Librarian){

        } else if(item instanceof LibraryMember){
            // create a checkout record
            LibraryMember libraryMember = (LibraryMember) item;
        }
        return ""; // TODO: FIX THIS
    }

    public String add(IRole.Level level, HashMap<String, String> values){
        // level ? we create the role object and assign
        String result ="";
        if(level == null){
            // LibraryMember
            // Create the CheckoutRecord
            Address memberAddress = new Address(values.get("street"), values.get("city"),
                    values.get("state"), values.get("zip"), values.get("country"));
            int memberId = Integer.parseInt(values.get("memberid"));
            LibraryMember libraryMember = new LibraryMember(memberId, values.get("firstname"),
                    values.get("lastname"),"password", values.get("phone"), memberAddress);
            new DataAccessFacade().savePerson(libraryMember);
            /*
             First before saving we query if the member id is there. If so we will return an error. We don't cover this scenario at the moment
              */
            result = ""+libraryMember.getMemberId(); // TODO: DECIDE either int or string for MEMBER ID
        } else if(level == Level.ADMIN){
            // admin process
        } else if(level == Level.LIBRARIAN){
            // Librarian process
        }

        return result;
    }



    @Override
    public Object update(Object item) {
        if(item instanceof Book){
            // TODO: Check the object structure to create before adding a book into the system
        } else if(item instanceof Author){

        } else if(item instanceof Librarian){

        } else if(item instanceof LibraryMember){

        }
        return null;
    }

    @Override
    public void remove(Object item) {
        if(item instanceof Book){
            // TODO: Check the object structure to create before adding a book into the system
        } else if(item instanceof Author){

        } else if(item instanceof Librarian){

        } else if(item instanceof LibraryMember){

        }

    }

    @Override
    public void setRole(IRole role) {
        // Set the role which can be Librarian
        this.role = role;

    }

    @Override
    public IRole getRole() {
        // Return the role he is playing, if No Librarian return null
        return role;
    }
}
