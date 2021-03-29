package laba.controller.commands;

import laba.model.Cramer;

public class CalcMatrixCommand implements Command{

    //private Cramer cramer = Cramer.getInstance();

    @Override
    public double[] execute(Cramer cramer) {
        double[] result = cramer.calcMatrix();
        return result;
    }
}
