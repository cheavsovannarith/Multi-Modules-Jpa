package com.sovannarith.info.RestController;

import com.sovannarith.info.UserService.UserService;
import com.sovannarith.info.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHello(){
        return "Hello";
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id){
        User user = userService.getUsers(id);
        System.out.println(user);
        return user;
    }

}
