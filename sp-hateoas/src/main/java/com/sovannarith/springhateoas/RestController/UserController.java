package com.sovannarith.springhateoas.RestController;


import com.sovannarith.springhateoas.UserService.UserService;
import com.sovannarith.springhateoas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
@RequestMapping(value = "/user", produces = "application/hal+json")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Resources<User>> getHello() {
        List<User> list = userService.getAll();
        final Resources<User> resource = new Resources<> (list);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resource.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id){
        User user = userService.getUsers(id);
        Resource<User> resource = new Resource(user);
        user.add(linkTo(methodOn(UserController.class).getUserById(user.getUserId())).withRel("user_link"));
        System.out.println(user);
        return user;
    }

}
