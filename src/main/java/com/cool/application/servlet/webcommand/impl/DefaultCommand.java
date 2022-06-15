package com.cool.application.servlet.webcommand.impl;

import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, Model model) {
        model.addAttribute(GlobalAttributes.MESSAGE, UserWarnings.NOTHING_FOUND_PER_YOUR_REQUEST);
        return UserPath.ERROR_PAGE;
    }

}
