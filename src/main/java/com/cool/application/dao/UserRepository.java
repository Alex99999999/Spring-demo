package com.cool.application.dao;

import com.cool.application.entity.User;
import com.cool.application.exception.db.DbException;
import com.cool.application.notifications.warnings.UserWarnings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users =  session.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
        session.close();
        return users;
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        User user = getUserById(id);
        if (user == null) {
            throw new DbException(UserWarnings.USER_NOT_FOUND);
        }
        Session session = sessionFactory.getCurrentSession();
        session.delete(getUserById(id));
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        Session session = sessionFactory.openSession();
        User user =  session.get(User.class, id);
        session.close();
        return user;
    }

    @Transactional
    @Override
    public List<User> getUserByFamilyName(String name) {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("SELECT u FROM User u WHERE family_name =: familyName", User.class)
                .setParameter("familyName", name)
                .getResultList();
        session.close();
        return users;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (!isExist(user.getId())) {
            throw new DbException(String.format(UserWarnings.USER_WITH_NAME_NOT_FOUND, user.getFamilyName()));
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        if (isExist(user.getId())) {
            throw new DbException(String.format(UserWarnings.USER_WITH_NAME_EXISTS, user.getFamilyName()));
        }
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    private boolean isExist(long id) {
        return getUserById(id) != null;
    }

}
