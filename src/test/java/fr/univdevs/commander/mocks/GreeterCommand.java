package fr.univdevs.commander.mocks;

import fr.univdevs.commander.Command;

public class GreeterCommand extends Command {

    public String execute(String[] args) {
        String out = "";
        for (String arg : args) {
            out += "Hello, " + arg + "!\n";
        }

        return out;
    }

    public String getSynopsis() {
        return this.getName() + " <persons...>\n"
            + "- persons : all the persons you want to say `Hello`.";
    }

    public String getName() {
        return "say-hello";
    }

}
