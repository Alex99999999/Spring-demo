package com.cool.application.service;

import com.cool.application.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    List<User> getUserByFamilyName(String name);

    void updateUser(User user);

    void createUser(User user);

    User findById(long id);

    void deleteUser(long id);
}
