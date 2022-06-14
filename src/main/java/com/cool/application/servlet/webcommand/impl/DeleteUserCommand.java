package com.cool.application.servlet.webcommand.impl;

import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

/**
 * Author Tetiana
 */

public class DeleteUserCommand implements Command {

    private final UserService userService;

    public DeleteUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Model model) {
//        long id = Utils.parseLong(modelAndView.getParameter(UserParameters.ID));
//        userService.deleteUser(id);
//        modelAndView.getSession().setAttribute(GlobalAttributes.MESSAGE, UserMessages.DELETE_SUCCESS);
        return String.format("user?command=%s", UserOperations.GET_ALL_USERS.getName());
    }

}