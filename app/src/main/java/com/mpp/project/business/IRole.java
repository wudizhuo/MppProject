package com.mpp.project.business;

/**
 * Created by prageeth on 3/6/17.
 */

public interface IRole {
//    public void add();
//    public boolean update();
//    public void delete();
//    public void create();
    enum Level { ADMIN,LIBRARIAN,BOTH}
    public void setRole(IRole role);
    public IRole getRole();
}
