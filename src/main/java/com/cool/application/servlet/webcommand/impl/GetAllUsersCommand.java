package com.cool.application.servlet.webcommand.impl;

import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component()
public class GetAllUsersCommand implements Command {

    private UserService userService;

    public GetAllUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Model model) {
        System.out.println("UserService----" + userService);
        List<User> users = userService.findAll();
        model.addAttribute(GlobalAttributes.USER_LIST, users);
        System.out.println("AGAIN GetAllUsersCommand-----");
        model.addAttribute(GlobalAttributes.USER_LIST, users);
        return Pages.SHOW_ALL_USERS;
    }

}