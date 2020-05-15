package com.spingweb.Service;

public interface UserService
{
    String addUser(String name, String surname);
    void removeUser(long id);
    void getUser(long id);
}
