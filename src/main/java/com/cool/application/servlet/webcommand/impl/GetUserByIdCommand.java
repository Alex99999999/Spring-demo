package com.cool.application.servlet.webcommand.impl;

import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.utils.Utils;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author Dmitriy
 */

public class GetUserByIdCommand implements Command {

    private final UserService userService;

    public GetUserByIdCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(ModelAndView modelAndView) {
//        long id = Utils.parseLong(modelAndView.getParameter(UserParameters.ID));
//        User user = userService.getUserById(id);
//        modelAndView.setAttribute(GlobalAttributes.USER, user);
        return Pages.USER_DETAILS_PAGE;
    }

}
