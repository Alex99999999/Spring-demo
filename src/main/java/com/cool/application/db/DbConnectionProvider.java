package com.cool.application.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnectionProvider {

    Connection getConnection();

}
