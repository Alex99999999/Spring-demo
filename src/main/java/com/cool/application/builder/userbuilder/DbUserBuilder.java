package com.cool.application.builder.userbuilder;

import com.cool.application.servlet.parameters.UserParameters;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUserBuilder extends AbstractUserBuilder {

    public DbUserBuilder(ResultSet resultSet) throws SQLException {
        id = resultSet.getLong(UserParameters.ID);
        familyName = resultSet.getString(UserParameters.FAMILY_NAME);
        givenName = resultSet.getString(UserParameters.GIVEN_NAME);
        phoneNumber = resultSet.getString(UserParameters.PHONE_NUMBER);
        age = resultSet.getInt(UserParameters.AGE);
    }

}
