package com.example.K2426Project3.repository;

import com.example.K2426Project3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword( String username, String password);

}
