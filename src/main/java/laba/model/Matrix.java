package laba.model;


import laba.Init;
import laba.Show;

public class Matrix implements Calculation {
    @Show(name="Matrix")
    static public int[][] matrix;
    @Show(name="determinant")
    public double determinant;

    @Override
    public double calculate(int[][] matr) {
        determinant = matr[0][0]*matr[1][1]*matr[2][2]
                + matr[0][1]*matr[1][2]*matr[2][0]
                + matr[0][2]*matr[1][0]*matr[2][1];
        determinant -= matr[0][2]*matr[1][1]*matr[2][0]
                + matr[0][0]*matr[1][2]*matr[2][1]
                + matr[0][1]*matr[1][0]*matr[2][2];
        return determinant;
    }


    public int[][] getMatrix(){
        return matrix;
    }
    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    public double getDeterminant() {
        return determinant;
    }

    public void setDeterminant(double determinant) {
        this.determinant = determinant;
    }




    /*@Init(name="Calculate determinant")
    public double calcDeterminant(){
        determinant = matrix[0][0]*matrix[1][1]*matrix[2][2]
                + matrix[0][1]*matrix[1][2]*matrix[2][0]
                + matrix[0][2]*matrix[1][0]*matrix[2][1];
        determinant -= matrix[0][2]*matrix[1][1]*matrix[2][0]
                + matrix[0][0]*matrix[1][2]*matrix[2][1]
                + matrix[0][1]*matrix[1][0]*matrix[2][2];
        return determinant;
    }*/
    /*public Matrix(int[][] matrix){
        this.matrix = matrix;
    }*/
}
