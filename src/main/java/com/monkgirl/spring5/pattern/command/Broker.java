package com.monkgirl.spring5.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 00:43
 * @description
 */
public class Broker {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommand() {
        for (Command command : commandList) {
            command.doCommand();
        }
    }
}
