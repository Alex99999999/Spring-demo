package com.cool.application.servlet.webcommand;

import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.impl.*;
import java.util.HashMap;
import java.util.Map;

public abstract class CommandContainer {

    protected Map<String, Command> commands;

    protected CommandContainer() {
        populateCommands();
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command, new DefaultCommand());
    }

    protected abstract UserService getUserService();

    private void populateCommands() {
        commands = new HashMap<>();
        commands.put(UserOperations.UPDATE_USER.getName(), new UpdateUserCommand(getUserService()));
        commands.put(UserOperations.GET_USER_BY_ID.getName(), new GetUserByIdCommand(getUserService()));
        commands.put(UserOperations.CREATE_USER.getName(), new CreateUserCommand(getUserService()));
        commands.put(UserOperations.GET_ALL_USERS.getName(), new GetAllUsersCommand(getUserService()));
        commands.put(UserOperations.GET_USER_BY_FAMILY_NAME.getName(), new GetUserByFamilyNameCommand((getUserService())));
        commands.put(UserOperations.DELETE_USER.getName(), new DeleteUserCommand(getUserService()));
    }

}
