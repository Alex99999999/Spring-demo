package com.cool.application.servlet.paths;

public final class UserPath {

    private UserPath() {
    }

    public static final String REDIRECT = "/user/?command=%s";
    public static final String REDIRECT_BY_ID = "/user/?command=%s&id=%d";
    public static final String ERROR_PAGE = "error";
    public static final String USER_DETAILS_PAGE = "show_user_details";
    public static final String SHOW_ALL_USERS = "show_all_users";

}
