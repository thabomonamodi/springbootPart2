package com.spingweb.Dao;

import com.spingweb.Model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FakeRepo implements FakeRepoInterface
{
    private static Map<Integer, User> user = new HashMap<Integer, User>();
    User user1;
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

    public void insertUser(long id, String name, String surname)
    {
        user1.setId(id);
        user1.setName(name);
        user1.setSurname(surname);

        System.out.println(user1.getName()+" "+user1.getSurname()+"user inserted");
        //user.put(user.getId(), (User) user);
    }
    public void insertUser(String name, String surname)
    {
        user1.setName(name);
        user1.setSurname(surname);

        System.out.println(user1.getName()+" "+user1.getSurname()+"user inserted");
        //user.put(user.getId(), (User) user);
    }
    @Cacheable
    public void findUserById(long id)
    {
        this.user.get(id);
    }

    public void deleteUser(long id)
    {
        if (user1.getId() == id)
        {
            this.user.remove(id);
            System.out.println(user1.getName()+" "+user1.getSurname()+" deleted successfully.");
        }
    }

}
