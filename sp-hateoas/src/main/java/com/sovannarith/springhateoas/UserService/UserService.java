package com.sovannarith.springhateoas.UserService;

import com.sovannarith.springhateoas.model.User;
import com.sovannarith.springhateoas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }

    public User getUsers(Long id){
        return ur.getOne(id);
    }

    public List<User> getAll(){return ur.findAll();}
}
