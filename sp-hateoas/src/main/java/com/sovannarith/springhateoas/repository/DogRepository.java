package com.sovannarith.springhateoas.repository;

import com.sovannarith.springhateoas.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {


    @Query(value = "Delete from dog where id = :id retruning *", nativeQuery = true)
    public Dog deleteByIdReturnValue(Long id);
}
