package com.sovannarith.sprestdocs.RestController;

import com.sovannarith.sprestdocs.UserService.UserService;
import com.sovannarith.sprestdocs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user;
    }

    @DeleteMapping("/users/{lst}")
    public void deleteAndReturn(@PathVariable Long[] lst){
        userService.deleteUsersWithIds(lst);
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
