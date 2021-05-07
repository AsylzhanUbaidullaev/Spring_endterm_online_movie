package com.asylzhan.spring.service;

import com.asylzhan.spring.entity.User;

import java.util.List;

public interface UserService {
    void create(User user);
//    boolean checkUser(String email, String password);
//    // checking with email
//    boolean hasUser(String email);
//    User getUser(String email);

    User findById(long id);
    List<User> getAllUsers();
    User findByEmail(String email);  // or User
    User update(User user);
    void delete(int id);
}
