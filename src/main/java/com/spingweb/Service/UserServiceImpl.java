package com.spingweb.Service;

import com.spingweb.Dao.FakeRepo;
import com.spingweb.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@EnableCaching
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

    public String addUser(String name, String surname)
    {
        repo.insertUser(name,surname);
        System.out.println(name+" "+surname+ " user inserted");
        return name;
    }

    public void removeUser(long id)
    {
        repo.deleteUser(id);
    }

    public void getUser(long id)
    {
        repo.findUserById(id);
    }

    @Cacheable("cachedUser")
    public String cachedUser(String name)
    {
        String msg = addUser(name, "");
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return msg;
    }
}
