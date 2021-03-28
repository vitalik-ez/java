package laba.model;

import laba.Init;

public class Cramer extends Matrix {

    static private int[] column;
    static private double[] result;
    private boolean noSolutions;

    private static Cramer instance = new Cramer();

    public static Cramer getInstance(){
        return instance;
    }

//    public Cramer(int[][] matrix, int[] column){
//        //super(matrix);
//        this.matrix = matrix;
//        this.column = column;
//    }

    @Init(name="Cramer's method")
    public double[] calcMatrix(){
        result = new double[3];
        double delta = super.calcDeterminant();
        if (delta != 0) {
            for (int i = 0; i < matrix.length; i++) {
                int[] copy = new int[3];
                for (int j = 0; j < matrix.length; j++) {
                    copy[j] = matrix[j][i];
                    matrix[j][i] = column[j];
                }
                result[i] = super.calcDeterminant() / delta;
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = copy[j];
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


    public boolean isNoSolutions() {
        return noSolutions;
    }
}
