package com.cool.application.servlet.webcommand.impl;

import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;
import org.springframework.ui.Model;

/**
 * Author ****
 */

public class DefaultCommand implements Command {

    @Override
    public String execute(Model model) {
//        modelAndView.setAttribute(GlobalAttributes.MESSAGE, UserWarnings.NOTHING_FOUND_PER_YOUR_REQUEST);
        return Pages.ERROR_PAGE;
    }

}
