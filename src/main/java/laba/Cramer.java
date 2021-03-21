package laba;

public class Cramer extends Matrix {

    private final double[] column;
    private double[] result;

    public Cramer(double[][] matrix, double[] column){
        super(matrix);
        this.column = column;
    }

    @Init(name="Cramer's method")
    public void calcMatrix(){
        result = new double[3];
        double delta = super.calcDeterminant();
        if (delta != 0){
            for(int i = 0; i < matrix.length; i++){
                double[] copy = new double[3];
                for(int j = 0; j < matrix.length; j++){
                    copy[j] = matrix[j][i];
                    matrix[j][i] = column[j];
                }
                result[i] = super.calcDeterminant() / delta;
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = copy[j];
                }
            }
        }
    }

    public double[] getResult(){
        return result;
    }

    @Override
    public String toString() {
        return "Result: x1=" + result[0] + " x2=" + result[1] + " x3=" + result[2];
    }
}
