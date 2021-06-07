package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllBy(Long Level);
    User findById(Long id);
    User save(User user);
    boolean delete(Long id);
}
