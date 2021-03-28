package laba.view;

public class CramerView {
    public void printCramerDetails(int[][] matr, int[] column, double[] result){
        System.out.println("Matrix:");
        for (int[] row : matr) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        System.out.println("Column:");
        for (int i = 0; i < column.length; i++) {
            System.out.print(column[i] + " ");
        }
        System.out.println();
        this.printResult(result);
    }

    public void printResult(double[] result){
        System.out.println("Result:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
