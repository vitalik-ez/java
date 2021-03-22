package laba;

public class Cramer extends Matrix {

    private int[] column;
    private double[] result;
    private boolean noSolutions;


    public Cramer(int[][] matrix, int[] column){
        super(matrix);
        this.column = column;
    }

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


//    @Override
//    public String toString() {
//        return "Result: x1=" + result[0] + " x2=" + result[1] + " x3=" + result[2];
//    }

    public boolean isNoSolutions() {
        return noSolutions;
    }
}
