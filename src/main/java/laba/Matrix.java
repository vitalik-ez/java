package laba;



public class Matrix implements Calculation{
    @Show(name="Matrix")
    protected double[][] matrix;
    @Show(name="determinant")
    public double determinant;

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }

    @Init(name="Calculate determinant")
    public double calcDeterminant(){
        determinant = matrix[0][0]*matrix[1][1]*matrix[2][2]
                + matrix[0][1]*matrix[1][2]*matrix[2][0]
                + matrix[0][2]*matrix[1][0]*matrix[2][1];
        determinant -= matrix[0][2]*matrix[1][1]*matrix[2][0]
                + matrix[0][0]*matrix[1][2]*matrix[2][1]
                + matrix[0][1]*matrix[1][0]*matrix[2][2];
        return determinant;
    }

    @Override
    public double getDeterminant() {
        return determinant;
    }

    @Override
    public void setDeterminant(double determinant) {
        this.determinant = determinant;
    }

}