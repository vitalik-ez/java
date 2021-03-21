package laba;

public class Main {

    public static void main(String[] args) {
        double[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
        double[] column = {0,13,14};
        // не мають рішення
//        double[][] matr = {{2,-1,3}, {3, -5, 1}, {4, -7, 1}};
//        double[] column = {9,-4, 5};


        Cramer cramer = new Cramer(matr, column);
        cramer.calcMatrix();
        System.out.println(cramer);
    }
}
