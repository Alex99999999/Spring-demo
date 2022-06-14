package com.cool.application.builder.userbuilder;

import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.utils.Utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUserBuilder extends AbstractUserBuilder {

    public HttpUserBuilder(HttpServletRequest request) {
        id = Utils.parseLong(request.getParameter(UserParameters.ID));
        familyName = request.getParameter(UserParameters.FAMILY_NAME);
        givenName = request.getParameter(UserParameters.GIVEN_NAME);
        phoneNumber = request.getParameter(UserParameters.PHONE_NUMBER);
        age = Utils.parseInt(request.getParameter(UserParameters.AGE));
    }

}