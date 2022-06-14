package com.cool.application.servlet.webcommand.impl;

import com.cool.application.service.UserService;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

/**
 * Author Dmitriy
 */

public class GetUserByIdCommand implements Command {

    private final UserService userService;

    public GetUserByIdCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Model model) {
//        long id = Utils.parseLong(modelAndView.getParameter(UserParameters.ID));
//        User user = userService.getUserById(id);
//        modelAndView.setAttribute(GlobalAttributes.USER, user);
        return Pages.USER_DETAILS_PAGE;
    }

}
