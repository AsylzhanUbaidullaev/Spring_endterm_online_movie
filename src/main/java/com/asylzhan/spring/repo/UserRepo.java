package com.asylzhan.spring.repo;

import com.asylzhan.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User getUserByEmailAndPassword(String email, String password);
    User getUserByEmail(String email);
    @Override
    List<User> findAll(); // ???

    User findById(long id);

    User findByEmail(String email);

}
