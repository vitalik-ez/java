package laba;

import java.util.Scanner;

public class CramerController {
    private Cramer model;
    private CramerView view;

    public CramerController(Cramer model, CramerView view) {
        this.model = model;
        this.view = view;
    }

    public double[] getCramerResult() {
        return model.getResult();
    }

    public void setCramerMatrix(int[][] matrix) {
        model.setMatrix(matrix);
    }
    public void setCramerColumn(int[] column) {
        model.setColumn(column);
    }


    public double[] calcCramerMatrix() {
        double[] result = model.calcMatrix();
        return result;
    }

    public void dataEntry(){
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
        this.setCramerMatrix(matr);
        this.setCramerColumn(column);
    }

    public void updateView() {
        view.printCramerDetails(model.getMatrix(), model.getColumn(), model.getResult());
    }
}
