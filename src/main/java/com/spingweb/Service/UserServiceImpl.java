package com.spingweb.Service;

import com.spingweb.Dao.FakeRepo;
import com.spingweb.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService
{
    private static Map<Integer, User> user;

    static
    {
        user = new HashMap<Integer, User>()
        {
            {
                put(1,new User(1,"Zoba","Roidz"));
                put(2,new User(2,"Bling","Dynamo"));
                put(3,new User(3,"Criss","Smart"));
                put(4,new User(4,"Rust","Eze"));
            }
        };
    }

    @Autowired
    private FakeRepo repo;

    @Override
    public void addUser(String name, String surname)
    {
        repo.insertUser(name,surname);
    }

    @Override
    public void removeUser(long id)
    {
        repo.deleteUser(id);
    }

    @Override
    public void getUser(long id)
    {
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        repo.findUserById(id);
    }
}