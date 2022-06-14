package com.cool.application.servlet.webcommand.impl;

import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

/**
 * Author Artem
 */

public class CreateUserCommand implements Command {

    private final UserService userService;

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }

    //TODO create user command fails when input fields remain empty. Find bug and fix it

    @Override
    public String execute(Model model) {
//        AbstractUserBuilder builder = new HttpUserBuilder(modelAndView);
//        User user = builder.buildUserWithAllFields();
//        userService.createUser(user);
//        modelAndView.setAttribute(GlobalAttributes.USER, user);
//        modelAndView.getSession().setAttribute(GlobalAttributes.MESSAGE, String.format(UserMessages.CREATE_SUCCESS, user.getFamilyName()));
        return String.format("user?command=%s", UserOperations.GET_ALL_USERS.getName());

    }

}
