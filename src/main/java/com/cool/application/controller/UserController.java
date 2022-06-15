package com.cool.application.controller;

import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.paths.UserPath;
import com.cool.application.servlet.parameters.GlobalParams;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.servlet.webcommand.CommandContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {

    @Autowired
    private CommandContainer commandContainer;

    @GetMapping("/")
    public String getModel(HttpServletRequest req, Model model) {
        return processRequest(req, model);
    }

    @PostMapping("/post")
    public String postModel(HttpServletRequest req, Model model) {
        return "redirect:" + processRequest(req, model);
    }

    private String processRequest(HttpServletRequest req, Model model) {
        String address = UserPath.ERROR_PAGE;
        String userCommand = req.getParameter(GlobalParams.COMMAND);
        try {
            Command command = commandContainer.getCommand(userCommand);
            address = command.execute(req, model);
        } catch (RuntimeException e) {
            model.addAttribute(GlobalAttributes.MESSAGE, e.getMessage());
        }
        return address;
    }

}
