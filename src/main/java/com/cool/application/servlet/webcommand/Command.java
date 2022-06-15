package com.cool.application.servlet.webcommand;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest req, Model model);

}
