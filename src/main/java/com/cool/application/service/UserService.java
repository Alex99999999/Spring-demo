package com.cool.application.service;

import com.cool.application.entity.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {

    String findAllUsers(Model model);

    String findUserById(String id, Model model);

    String deleteUser(String id, Model model);

    List<User> getUserByFamilyName(String name);

    void updateUser(User user);

    void createUser(User user);

}
