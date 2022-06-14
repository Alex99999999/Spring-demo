package com.cool.application.servlet.webcommand.impl;

import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

/**
 * Author Alexander
 */

public class UpdateUserCommand implements Command {

    private final UserService userService;

    public UpdateUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Model model) {
//        AbstractUserBuilder builder = new HttpUserBuilder(modelAndView);
//        User user = builder.buildUserWithAllFields();
//        userService.updateUser(user);
//        modelAndView.getSession().setAttribute(GlobalAttributes.MESSAGE, String.format(UserMessages.UPDATE_SUCCESS, user.getFamilyName()));
//        return String.format("user?command=%s&id=%d", UserOperations.GET_USER_BY_ID.getName(), user.getId());
        return "";
    }

}