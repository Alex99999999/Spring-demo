package com.cool.application.operations;

public enum UserOperations {

    UPDATE_USER("update_user"),
    CREATE_USER("create_user"),
    GET_USER_BY_ID("get_user_by_id"),
    DELETE_USER("delete_user"),
    GET_ALL_USERS("get_all_users"),
    GET_USER_BY_FAMILY_NAME("get_user_by_family_name");

    private final String query;

    UserOperations(String query) {
        this.query = query;
    }

    public String getName() {
        return query;
    }

}