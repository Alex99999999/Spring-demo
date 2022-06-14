package com.cool.application.builder.userbuilder;

import com.cool.application.entity.User;
import com.cool.application.validator.Validator;

public abstract class AbstractUserBuilder {

    private static final String DEFAULT_PHONE_NUMBER = "+000000000000";
    private static final String DEFAULT_FAMILY_NAME = "AAAAA";

    private static User user;
    protected static long id;
    protected static String familyName;
    protected static String givenName;
    protected static String phoneNumber;
    protected static int age;

    public User buildUserWithAllFields() {
        return new Builder().
                withId()
                .withFamilyName()
                .withGivenName()
                .withPhoneNumber()
                .withAge()
                .build();
    }

    public static Builder getInstance() {
        return new Builder();
    }

    public static class Builder {

        public Builder() {
            user = new User();
        }

        public Builder withId() {
            user.setId(id);
            return this;
        }

        public Builder withFamilyName() {
            if (Validator.isEmptyOrNullString(familyName)) {
                familyName = DEFAULT_FAMILY_NAME;
            }
            user.setFamilyName(familyName);
            return this;
        }

        public Builder withGivenName() {
            Validator.validateStringNotNullNotEmpty(familyName);
            user.setGivenName(givenName);
            return this;
        }

        public Builder withPhoneNumber() {
            if (Validator.isEmptyOrNullString(familyName)) {
                phoneNumber = DEFAULT_PHONE_NUMBER;
            }
            user.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder withAge() {
            Validator.validateNumberGreaterThanZero(age);
            user.setAge(age);
            return this;
        }

        public User build() {
            return user;
        }
    }

}
