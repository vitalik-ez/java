package laba.model;

import laba.Init;

public class Cramer{

    private Matrix matrix;
    static private int[] column;
    static private double[] result;
    private boolean noSolutions;

    public void setMatrix(Matrix matrix){
        this.matrix = matrix;
    }

    @Init(name="Cramer's method")
    public double[] calcMatrix(){
        result = new double[3];
        int[][] matr = matrix.getMatrix();
        double delta = calculate(matr);
        if (delta != 0) {
            for (int i = 0; i < matr.length; i++) {
                int[] copy = new int[3];
                for (int j = 0; j < matr.length; j++) {
                    copy[j] = matr[j][i];
                    matr[j][i] = column[j];
                }
                result[i] = calculate(matr) / delta;
                for (int j = 0; j < matr.length; j++) {
                    matr[j][i] = copy[j];
                }
            }
        } else {
            noSolutions = true;
            result = null;
        }
        return result;
    }

    public double[] getResult(){
        return result;
    }
    public int[] getColumn(){
        return column;
    }
    public void setColumn(int[] column){
        this.column = column;
    }

    public int[][] getMatrix(){
        return matrix.getMatrix();
    }

    public void setMatr(int[][] matr){
        this.matrix.setMatrix(matr);
    }

    public boolean isNoSolutions() {
        return noSolutions;
    }

    public double calculate(int[][] matr) {
        return matrix.calculate(matr);
    }
}
