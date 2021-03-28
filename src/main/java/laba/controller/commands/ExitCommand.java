package laba.controller.commands;

public class ExitCommand implements Command{

    private static ExitCommand exitCommand = new ExitCommand();

    public static Command getInstance() {
        return exitCommand;
    }

    @Override
    public double[] execute() {
        System.exit(0);
        return null;
    }
}
