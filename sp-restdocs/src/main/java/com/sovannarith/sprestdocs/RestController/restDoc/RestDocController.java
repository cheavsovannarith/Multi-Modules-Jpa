package com.sovannarith.sprestdocs.RestController.restDoc;

import com.sovannarith.sprestdocs.UserService.UserService;
import com.sovannarith.sprestdocs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

//@RestController
public class RestDocController {

    UserService userService;

    @Autowired
    RestDocController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Long id){
        User user = userService.getUserById(1L);
        return new User(1L, ":",":");
    }

    @DeleteMapping("/users/{lst}")
    public void deleteAndReturn(@PathVariable Long[] lst){
        userService.deleteUsersWithIds(lst);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user){
//        return userService.updateUser(user);
        User user1 = new User(1L, "updated_name", "updated_gender");
        return user1;
    }

}
