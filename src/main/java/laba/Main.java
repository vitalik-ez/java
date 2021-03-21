package laba;

public class Main {

    public static void main(String[] args) {
        double[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
        double[] column = {0,13,14};
        Cramer cramer = new Cramer(matr, column);
        cramer.calcMatrix();
        System.out.println(cramer);

    }
}
