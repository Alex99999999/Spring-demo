package com.cool.application.servlet.webcommand;

import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandContainer {

    protected Map<String, Command> commands;

    public Command getCommand(String command) {
        System.out.println("CommandContainer commands size --> " + commands.size());
        return commands.getOrDefault(command, new DefaultCommand());
    }

    protected abstract void populateCommands();

//    private void populateCommands() {
//        commands = new HashMap<>();
//        commands.put(UserOperations.UPDATE_USER.getName(), new UpdateUserCommand(userService));
//        commands.put(UserOperations.GET_USER_BY_ID.getName(), new GetUserByIdCommand(userService));
//        commands.put(UserOperations.CREATE_USER.getName(), new CreateUserCommand(userService));
//        commands.put(UserOperations.GET_ALL_USERS.getName(), getAllUsersCommand);
//        commands.put(UserOperations.GET_USER_BY_FAMILY_NAME.getName(), new GetUserByFamilyNameCommand((userService)));
//        commands.put(UserOperations.DELETE_USER.getName(), new DeleteUserCommand(userService));
//    }

}
