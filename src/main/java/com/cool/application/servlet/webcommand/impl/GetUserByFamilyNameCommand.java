package com.cool.application.servlet.webcommand.impl;

import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.service.UserService;
import com.cool.application.entity.User;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author Bogdan
 */

public class GetUserByFamilyNameCommand implements Command {

    private final UserService userService;

    public GetUserByFamilyNameCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(ModelAndView modelAndView) {
//        String name = modelAndView.getParameter(UserParameters.FAMILY_NAME);
//        List<User> users = userService.getUserByFamilyName(name);
//        if (users.size() == 0) {
//            modelAndView.getSession().setAttribute(GlobalAttributes.MESSAGE, String.format(UserWarnings.USER_WITH_NAME_NOT_FOUND, name));
//            modelAndView.setAttribute(GlobalAttributes.MESSAGE, UserWarnings.NOTHING_FOUND_PER_YOUR_REQUEST);
//        }
//        modelAndView.setAttribute(GlobalAttributes.USER_LIST, users);
        return Pages.SHOW_ALL_USERS;
    }

}