package com.sovannarith.sprestdocs.repository;

import com.sovannarith.sprestdocs.model.User;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    /**
     * Delete all user with ids specified in {@code ids} parameter
     *
     * @param ids List of user ids
     */
    @Transactional
    @Modifying
    @Query("delete from User u where u.id in ?1")
    public void deleteUsersWithIds(Long[] ids);

}
