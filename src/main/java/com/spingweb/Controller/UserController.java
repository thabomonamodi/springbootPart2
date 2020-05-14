package com.spingweb.Controller;

import com.spingweb.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserServiceImpl impl;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public void getUser(@PathVariable("id")int id)
    {
        impl.getUser(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public void addUser(@RequestBody String name, String surname)
    {
        impl.addUser(name, surname);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id")int id)
    {
        impl.removeUser(id);
    }
}
