package laba.model;


import laba.Calculation;
import laba.Init;
import laba.Show;

public class Matrix implements Calculation {
    @Show(name="Matrix")
    static public int[][] matrix;
    @Show(name="determinant")
    public double determinant;

    private static Matrix instance = new Matrix();
    public static Matrix getInstance(){
        return instance;
    }

    /*public Matrix(int[][] matrix){
        this.matrix = matrix;
    }*/


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

    public int[][] getMatrix(){
        return matrix;
    }
    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
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