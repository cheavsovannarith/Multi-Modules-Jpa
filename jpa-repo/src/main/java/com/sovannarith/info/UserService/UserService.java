package com.sovannarith.info.UserService;

import com.sovannarith.info.model.User;
import com.sovannarith.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
