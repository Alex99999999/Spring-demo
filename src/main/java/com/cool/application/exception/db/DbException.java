package com.cool.application.exception.db;

public class DbException extends RuntimeException {

    public DbException(String message) {
        super(message);
    }

    public DbException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
