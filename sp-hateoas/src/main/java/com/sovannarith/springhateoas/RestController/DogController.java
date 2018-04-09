package com.sovannarith.springhateoas.RestController;

import com.sovannarith.springhateoas.UserService.DogService;
import com.sovannarith.springhateoas.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value = "/dog", produces = "application/hal+json")
public class DogController {

    private DogService dogService;

    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/{id}")
    public Resource<Dog> getDogById(@PathVariable Long id){

        Dog dog = dogService.getDogById(id);
        Resource<Dog> resource = new Resource<Dog>(dog);
        resource.add(linkTo(methodOn(DogController.class).getDogs()).withRel("all-dog"));
        return resource;

    }

    @GetMapping("")
    public Resources<List<Dog>> getDogs(){

        List<Dog> dogs = dogService.getAll();
        Resources<List<Dog>> kk = new Resources<List<Dog>>(Collections.singleton(dogs));

        for(int i = 0; i < dogs.size(); i++){
            kk.add(linkTo(methodOn(DogController.class).getDogById(dogs.get(i).getId())).withRel("Dog"));
        }
        return kk;
    }

    @DeleteMapping(value = "/{id}")
    public Resource<Dog> deleteDogAndReturnRowBack(@PathVariable Long id){
        Dog deletedDog = null;
        if(id != null || id < 0)
            deletedDog = dogService.deleteAndReturn(id);

        Resource<Dog> resource = new Resource<Dog>(deletedDog);
        resource.add(linkTo(methodOn(DogController.class).getDogs()).withRel("all-dog"));
        return resource;

    }

}
