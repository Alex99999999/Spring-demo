package com.cool.application.dao;

import com.cool.application.db.UserQueries;
import com.cool.application.entity.User;
import com.cool.application.exception.db.DbException;
import com.cool.application.notifications.warnings.DbWarnings;
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

    @Autowired
    private UserQueries userQueries;

    @Transactional
    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE from User WHERE id =: userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    @Override
    public List<User> getUserByFamilyName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u WHERE family_name =: familyName", User.class)
                .setParameter("familyName", name)
                .getResultList();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (!isExist(user.getId())) {
            throw new DbException(String.format(UserWarnings.USER_WITH_NAME_NOT_FOUND, user.getFamilyName()));
        }
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("UPDATE User SET family_name =: familyName, given_name =: givenName, phone_number =: phoneNumber, age =: age WHERE id =: userId")
                .setParameter("familyName", user.getFamilyName())
                .setParameter("givenName", user.getGivenName())
                .setParameter("phoneNumber", user.getPhoneNumber())
                .setParameter("age", user.getAge())
                .setParameter("userId", user.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        if (isExist(user.getId())) {
            throw new DbException(String.format(UserWarnings.USER_WITH_NAME_EXISTS, user.getFamilyName()));
        }
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
//        session.createQuery("INSERT INTO User SET (family_name, given_name, phone_number, age)")
//                .setParameter("familyName", user.getFamilyName())
//                .setParameter("givenName", user.getGivenName())
//                .setParameter("phoneNumber", user.getPhoneNumber())
//                .setParameter("age", user.getAge())
//                .executeUpdate();
    }

    private boolean isExist(long id) {
        return getUserById(id) != null;
    }

}
