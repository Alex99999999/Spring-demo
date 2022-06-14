package com.cool.application.db.postgres.queries.user;

import com.cool.application.db.UserQueries;
import com.cool.application.operations.UserOperations;

import java.util.HashMap;
import java.util.Map;

public class PostgresUserQueries implements UserQueries {

    private Map<String, String> queries;

    public PostgresUserQueries() {
        populateQueries();
    }

    private void populateQueries() {
        queries = new HashMap<>();
        queries.put(
                UserOperations.UPDATE_USER.getName(),
                "UPDATE \"user\" SET family_name = ?,  given_name = ?, phone_number = ?, age = ? WHERE id = ?;");
        queries.put(
                UserOperations.CREATE_USER.getName(),
                "INSERT INTO \"user\" (family_name,given_name,phone_number, age) VALUES (?,?,?,?)");
        queries.put(
                UserOperations.GET_USER_BY_ID.getName(), "SELECT * from \"user\" WHERE id = ?");
        queries.put(
                UserOperations.DELETE_USER.getName(), "DELETE from \"user\" WHERE id = ?");
        queries.put(UserOperations.GET_ALL_USERS.getName(), "SELECT * from \"user\";");
        queries.put(UserOperations.GET_USER_BY_FAMILY_NAME.getName(), "SELECT * from \"user\" WHERE family_name = ?;");
    }

    public String getQuery(String key) {
        return queries.get(key);
    }

}