package com.cool.application.service.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.entity.User;
import com.cool.application.notifications.warnings.messages.UserMessages;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
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
  public List<User> findAllUsers() {
    return userDao.findAllUsers();
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

  @Override
  public User findById(long id) {
    return userDao.getUserById(id);
  }

  @Override
  public void deleteUser(long id) {
    userDao.deleteUser(id);
  }

}
