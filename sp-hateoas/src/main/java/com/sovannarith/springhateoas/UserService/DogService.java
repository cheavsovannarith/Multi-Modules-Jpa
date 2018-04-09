package com.sovannarith.springhateoas.UserService;

import com.sovannarith.springhateoas.model.Dog;
import com.sovannarith.springhateoas.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAll(){
        return dogRepository.findAll();
    }

    public Dog getDogById(Long id){
        return dogRepository.getOne(id);
    }

    public void deleteById(Long id) { dogRepository.deleteById(id);}

    public Dog deleteAndReturn (Long id){ return dogRepository.deleteByIdReturnValue(id);}

}
