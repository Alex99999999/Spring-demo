package com.cool.application.dao.impl;

import com.cool.application.builder.userbuilder.DbUserBuilder;
import com.cool.application.dao.UserDao;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.UserQueries;
import com.cool.application.entity.User;
import com.cool.application.exception.db.DbException;
import com.cool.application.exception.user.*;
import com.cool.application.notifications.warnings.DbWarnings;
import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.operations.UserOperations;
import com.cool.application.utils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    private DbConnectionProvider connectionProvider;
    @Autowired
    private UserQueries queries;

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        Connection con = connectionProvider.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = queries.getQuery(UserOperations.GET_ALL_USERS.getName());
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs == null) {
                throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
            }
            while (rs.next()) {
                User user = new DbUserBuilder(rs).buildUserWithAllFields();
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
        } finally {
            DbUtils.close(rs);
            DbUtils.close(stmt);
            DbUtils.close(con);
        }
        return users;
    }

    @Override
    public void deleteUser(long id) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement pstmt = null;
        isExist(id);
        try {
            String sql = queries.getQuery(UserOperations.DELETE_USER.getName());
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserException(String.format(UserWarnings.USER_DELETE_FAILURE, id));
        } finally {
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
    }

    @Override
    public User getUserById(long id) {
        Connection con = connectionProvider.getConnection();
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = queries.getQuery(UserOperations.GET_USER_BY_ID.getName());
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs == null) {
                throw new UserException(UserWarnings.NOTHING_FOUND_PER_YOUR_REQUEST);
            }
            if (rs.next()) {
                user = new DbUserBuilder(rs).buildUserWithAllFields();
            }
        } catch (SQLException e) {
            throw new UserException(String.format(UserWarnings.USER_RETRIEVE_FAILURE, id));
        } finally {
            DbUtils.close(rs);
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
        return user;
    }

    @Override
    public List<User> getUserByFamilyName(String name) {
        List<User> users = new ArrayList<>();
        Connection con = connectionProvider.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = queries.getQuery(UserOperations.GET_USER_BY_FAMILY_NAME.getName());
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs == null) {
                throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
            }
            while (rs.next()) {
                User user = new DbUserBuilder(rs).buildUserWithAllFields();
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DbException(DbWarnings.DB_OPERATION_FAILURE);
        } finally {
            DbUtils.close(rs);
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement pstmt = null;
        long id = user.getId();
        isExist(id);
        try {
            String sql = queries.getQuery(UserOperations.UPDATE_USER.getName());
            pstmt = con.prepareStatement(sql);
            int k = 0;
            pstmt.setString(++k, user.getFamilyName());
            pstmt.setString(++k, user.getGivenName());
            pstmt.setString(++k, user.getPhoneNumber());
            pstmt.setInt(++k, user.getAge());
            pstmt.setLong(++k, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserException(String.format(UserWarnings.USER_UPDATE_FAILURE, id));
        } finally {
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
    }

    @Override
    public void createUser(User user) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = queries.getQuery(UserOperations.CREATE_USER.getName());
            stmt = con.prepareStatement(sql);
            int k = 0;
            stmt.setString(++k, user.getFamilyName());
            stmt.setString(++k, user.getGivenName());
            stmt.setString(++k, user.getPhoneNumber());
            stmt.setInt(++k, user.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserException(String.format(UserWarnings.USER_CREATE_FAILURE));
        } finally {
            DbUtils.close(stmt);
            DbUtils.close(con);
        }
    }

    private void isExist(long id) {
        if (getUserById(id) == null) {
            throw new UserException(String.format(UserWarnings.USER_NOT_FOUND, id));
        }
    }

}
