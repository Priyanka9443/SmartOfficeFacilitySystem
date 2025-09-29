// src/services/CommandInvoker.java
package services;

import commands.Command;

public class CommandInvoker {
    public static void execute(Command command) {
        command.execute();
    }
}
