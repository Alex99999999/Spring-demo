package com.cool.application.servlet.webcommand.impl;

import com.cool.application.notifications.warnings.messages.UserMessages;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.utils.Utils;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {

    private final UserService userService;

    public DeleteUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, Model model) {
        long id = Utils.parseLong(req.getParameter(UserParameters.ID));
        userService.deleteUser(id);
        req.getSession().setAttribute(GlobalAttributes.MESSAGE, UserMessages.DELETE_SUCCESS);
        return String.format(UserPath.REDIRECT, UserOperations.GET_ALL_USERS.getName());
    }

}