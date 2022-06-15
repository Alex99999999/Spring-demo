package com.cool.application.servlet.webcommand.impl;

import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component()
public class GetAllUsersCommand implements Command {

    private final UserService userService;

    public GetAllUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req,  Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute(GlobalAttributes.USER_LIST, users);
        model.addAttribute(GlobalAttributes.USER_LIST, users);
        return UserPath.SHOW_ALL_USERS;
    }

}