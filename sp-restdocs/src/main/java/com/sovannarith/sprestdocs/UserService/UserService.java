package com.sovannarith.sprestdocs.UserService;

import com.sovannarith.sprestdocs.model.User;
import com.sovannarith.sprestdocs.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }

    public User getUserById(Long id){
        User user = ur.getOne(id);
        if (user != null) return user;
        return new User(null ,null, null);
    }

    public List<User> getAllUser(){ return ur.findAll();}

    public void deleteUsersWithIds(Long[] lst){ ur.deleteUsersWithIds(lst);}

    public User updateUser(User user){
        User u = new User ();
        try{
            u = ur.getOne(user.getId());
            if (u != null){
                u.setGender(user.getGender());
                u.setName(user.getName());
                ur.save(u);
                return u;
            }
        }catch (Exception nef){

        }
        return new User(null, null, null);
    }
}
