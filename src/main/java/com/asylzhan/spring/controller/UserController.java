package com.asylzhan.spring.controller;

import com.asylzhan.spring.entity.User;
import com.asylzhan.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/find/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/create")
    public void saveUser(@RequestBody User user) {
        userService.create(user);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    //    public boolean hasUser(String email, String password) {
//        return userService.checkUser(email, password);
//    }
//
//    public boolean hasUser(String email) {
//        return userService.hasUser(email);
//    }
//    public User getUser(String email) {
//        return userService.getUser(email);
//    }
}
