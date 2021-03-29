package laba.controller.commands;

import laba.model.Cramer;

public interface Command {
    double[] execute(Cramer cramer);
}
