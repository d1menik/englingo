package com.app.web.repository;

import com.app.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findUserByName(String username);

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User findUserByUsername(String username);

    @Override
    @Modifying
    @Query(value = "DELETE FROM User u WHERE u.id = :id")
    void deleteById(Integer id);

}

