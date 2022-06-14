package com.cool.application.servlet.webcommand;

import org.springframework.web.servlet.ModelAndView;

public interface Command {

    String execute(ModelAndView modelAndView);

}
