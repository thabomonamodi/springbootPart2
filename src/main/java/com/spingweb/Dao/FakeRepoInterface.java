package com.spingweb.Dao;

public interface FakeRepoInterface
{
    void insertUser(long id, String name, String surname);
    void findUserById(long id);
    void deleteUser(long id);
}
