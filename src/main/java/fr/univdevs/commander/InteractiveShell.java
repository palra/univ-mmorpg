package fr.univdevs.commander;

import java.util.Scanner;

/**
 * Simple interactive shell, powered by the CommandParser.
 *
 * @author Loïc Payol
 */
public class InteractiveShell {

    public static void main(String[] args) {
        CommandParser parser = new CommandParser();
        ExitCommand exit = new ExitCommand();
        parser.add(exit);
        parser.add(new HelpCommand(parser));

        Scanner sc = new Scanner(System.in);

        while (!exit.isClosed()) {
            System.out.print("msh> ");
            String in = sc.nextLine();
            ParserResult res;

            try {
                res = parser.parse(in);
                System.out.print((res.getOutput() == null) ? "" : res.getOutput());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class ExitCommand implements Command {

        private boolean closed = false;

        public String execute(String[] args) throws Exception {
            this.setClosed(true);
            return null;
        }

        public String getArgumentsDescription() {
            return this.getName();
        }

        public String getName() {
            return "exit";
        }

        public boolean isClosed() {
            return this.closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }
    }

    public static class HelpCommand implements Command {

        private CommandParser parser;

        public HelpCommand(CommandParser parser) {
            this.parser = parser;
        }

        public String execute(String[] args) throws Exception {
            String out = "";
            boolean showDesc = args.length > 1 && args[0].matches("with-desc");

            for (Command cmd : parser.getCommands()) {
                if (showDesc)
                    out += cmd.getArgumentsDescription();
                else
                    out += cmd.getName();

                out += "\n";
            }

            return out;
        }

        public String getArgumentsDescription() {
            return this.getName() + "[ --with-desc ]";
        }

        public String getName() {
            return "help";
        }
    }
}
