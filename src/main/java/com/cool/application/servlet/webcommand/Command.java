package com.cool.application.servlet.webcommand;

import org.springframework.ui.Model;

public interface Command {

    String execute(Model model);

}
