package laba.controller.commands;

import laba.model.Cramer;

public class ExitCommand implements Command{

    private static ExitCommand exitCommand = new ExitCommand();

    public static Command getInstance() {
        return exitCommand;
    }

    @Override
    public double[] execute(Cramer cramer) {
        System.exit(0);
        return null;
    }
}
