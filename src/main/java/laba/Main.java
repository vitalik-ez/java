package laba;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[][] matr = new int[3][3];
        int[] column = new int[3];

        Scanner in = new Scanner(System.in);
        for (int i=0; i < 3; i++){
            for (int j=0; j<3; j++){
                System.out.print("Input a number matr[" + i + "][" + j + "]: ");
                matr[i][j] = in.nextInt();
            }
        }
        for (int i=0; i < 3; i++){
            System.out.print("Input a column[" + i + "]: ");
            column[i] = in.nextInt();
        }
//        int[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
//        int[] column = {0,13,14};
        // не мають рішення
//        double[][] matr = {{2,-1,3}, {3, -5, 1}, {4, -7, 1}};
//        double[] column = {9,-4, 5};


        Cramer cramer = new Cramer(matr, column);
        cramer.calcMatrix();
        CramerView view = new CramerView();

        CramerController controller = new CramerController(cramer, view);
        controller.calcCramerMatrix();
        controller.updateView();

    }
}
