package com.project.splitwise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commands;


    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand,
                           UpdateProfileCommand updateProfileCommand,
                           AddGroupCommand addGroupCommand,
                           AddMemberCommand addMemberCommand,
                           GetGroupsCommand getGroupsCommand) {
        commands = new ArrayList<>();
        commands.add(registerUserCommand);
        commands.add(updateProfileCommand);
        commands.add(addGroupCommand);
        commands.add(addMemberCommand);
        commands.add(getGroupsCommand);
    }

    public void execute(String input){
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }

        }
    }
}
