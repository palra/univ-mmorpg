package fr.univdevs.commander.mocks;

import fr.univdevs.commander.Command;

public class GreeterCommand implements Command {

    public String execute(String[] args) {
        String out = "";
        for (String arg : args) {
            out += "Hello, " + arg + "!\n";
        }

        return out;
    }

    public String getArgumentsDescription() {
        return this.getName() + " <persons...>\n"
            + "- persons : all the persons you want to say `Hello`.";
    }

    public String getName() {
        return "say-hello";
    }

}
