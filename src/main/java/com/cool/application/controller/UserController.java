package com.cool.application.controller;

import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.GlobalParams;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.servlet.webcommand.CommandContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private CommandContainer commandContainer;
    private Command command;

    @GetMapping("/")
    public String getAllUsers(@RequestParam(name = "command") String userCommand, Model model) {
        String address = Pages.ERROR_PAGE;

        System.out.println("CommandContainer---------" + commandContainer);
        System.out.println("RequestParam---------" + userCommand);

        try {
            command = commandContainer.getCommand(userCommand);
            System.out.println("Command---------" + command);
            address = userService.findAllUsers(model);
        } catch (RuntimeException e) {
            model.addAttribute(GlobalAttributes.MESSAGE, e.getMessage());
        }
        return address;
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam(name = "id") String id, Model model) {
        String address = Pages.ERROR_PAGE;
        try {
            address = userService.deleteUser(id, model);
        } catch (RuntimeException e) {
            model.addAttribute(GlobalAttributes.MESSAGE, e.getMessage());
        }
        return address;
    }

}
