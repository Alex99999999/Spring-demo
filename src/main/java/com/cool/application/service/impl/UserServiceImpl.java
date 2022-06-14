package com.cool.application.service.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.entity.User;
import com.cool.application.notifications.warnings.messages.UserMessages;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public String findAllUsers(Model model) {
    List<User> users = userDao.findAllUsers();
    model.addAttribute(GlobalAttributes.USER_LIST, users);
    return Pages.SHOW_ALL_USERS;
  }

  @Override
  public String findUserById(String id, Model model) {
    return null;
  }


  @Override
  public String deleteUser(String inputId, Model model) {
    long id = Utils.parseLong(inputId);
    userDao.deleteUser(id);
    model.addAttribute(GlobalAttributes.MESSAGE, UserMessages.DELETE_SUCCESS);
    model.addAttribute(GlobalAttributes.USER_LIST, userDao.findAllUsers());
    return Pages.SHOW_ALL_USERS;
  }

  @Override
  public List<User> getUserByFamilyName(String name) {
    return userDao.getUserByFamilyName(name);
  }

  @Override
  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  @Override
  public void createUser(User user) {
    userDao.createUser(user);
  }

}
