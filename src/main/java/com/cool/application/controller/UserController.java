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

    @GetMapping("/get_all_users")
    public String getAllUsers(Model model) {
        String address = Pages.ERROR_PAGE;
        try {
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


//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView getMethod(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("CommandContainer ---- " + commandContainer);
//        System.out.println("Parameter ---- " + req.getParameter(GlobalParams.COMMAND));
//        String address = Pages.ERROR_PAGE;
//        ModelAndView modelAndView = new ModelAndView();
//        try {
//            command = commandContainer.getCommand(req.getParameter(GlobalParams.COMMAND));
//            address = command.execute(modelAndView);
//            System.out.println("Address ---- " + address);
//            System.out.println("modelAndView ---- " + modelAndView.getModel());
//        } catch (RuntimeException e) {
//            modelAndView.addObject(GlobalAttributes.MESSAGE, e.getMessage());
//        }
//        modelAndView.setViewName(address);
//        return modelAndView;
//    }
//}


//
//@WebServlet("/user")
//public class UserController extends HttpServlet {
//
//    private CommandContainer commandContainer;
//    private Command command;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        commandContainer = (CommandContainer) req.getServletContext().getAttribute(GlobalAttributes.COMMAND_CONTAINER);
//        String address = Pages.ERROR_PAGE;
//        try {
//            command = commandContainer.getCommand(req.getParameter(GlobalParams.COMMAND));
//            address = command.execute(req);
//        } catch (RuntimeException e) {
//            req.getSession().setAttribute(GlobalAttributes.MESSAGE, e.getMessage());
//        }
//        req.getRequestDispatcher(address).forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        commandContainer = (CommandContainer) req.getServletContext().getAttribute(GlobalAttributes.COMMAND_CONTAINER);
//        String address = Pages.ERROR_PAGE;
//        try {
//            command = commandContainer.getCommand(req.getParameter(GlobalParams.COMMAND));
//            address = command.execute(req);
//        } catch (RuntimeException e) {
//            req.getSession().setAttribute(GlobalAttributes.MESSAGE, e.getMessage());
//        }
//        resp.sendRedirect(address);
//    }
//
//}
