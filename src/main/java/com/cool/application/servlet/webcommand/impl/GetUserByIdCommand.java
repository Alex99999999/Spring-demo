package com.cool.application.servlet.webcommand.impl;

import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.utils.Utils;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public class GetUserByIdCommand implements Command {

    private final UserService userService;

    public GetUserByIdCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, Model model) {
        long id = Utils.parseLong(req.getParameter(UserParameters.ID));
        User user = userService.findById(id);
        model.addAttribute(GlobalAttributes.USER, user);
        return UserPath.USER_DETAILS_PAGE;
    }

}
