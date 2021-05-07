package com.asylzhan.spring.service.impl;

import com.asylzhan.spring.entity.User;
import com.asylzhan.spring.repo.UserRepo;
import com.asylzhan.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        if (user == null){
            throw new UsernameNotFoundException("User: " + username + " not found");
        }
        return user;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    //    @Override
//    public boolean checkUser(String email, String password) {
//        User user = userRepo.getUserByEmailAndPassword(email, password);
//        return (user != null);
//    }
//
//    @Override
//    public boolean hasUser(String email) {
//        User user = userRepo.getUserByEmail(email);
//        return (user != null);
//    }
//
//    @Override
//    public User getUser(String email) {
//        return userRepo.getUserByEmail(email);
//    }
}
