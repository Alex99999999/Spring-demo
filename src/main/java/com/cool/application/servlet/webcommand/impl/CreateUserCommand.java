package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.entity.User;
import com.cool.application.notifications.warnings.messages.UserMessages;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public class CreateUserCommand implements Command {

    private final UserService userService;

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }

    //TODO create user command fails when input fields remain empty. Find bug and fix it

    @Override
    public String execute(HttpServletRequest req, Model model) {
        AbstractUserBuilder builder = new HttpUserBuilder(req);
        User user = builder.buildUserWithAllFields();
        userService.createUser(user);
        model.addAttribute(GlobalAttributes.USER, user);
        model.addAttribute(GlobalAttributes.MESSAGE, String.format(UserMessages.CREATE_SUCCESS, user.getFamilyName()));
        return String.format(UserPath.REDIRECT, UserOperations.GET_ALL_USERS.getName());
    }

}
