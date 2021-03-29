package laba;

import laba.model.Cramer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CramerTest {

    @Test
    void calcMatrix_True_IfMatrixCalculationIsRight() {
        int[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
        int[] column = {0,13,14};
        Cramer cramer = new Cramer(matr, column);
//        cramer.setMatrix(matr);
//        cramer.setColumn(column);
        cramer.calcMatrix();
        double[] expected_result = {1,2,3};
        assertArrayEquals(expected_result, cramer.getResult());
    }

    @Test
    void calcMatrix_True_IfMatrixHasNotSolutions() {
        int[][] matr = {{2,-1,3}, {3, -5, 1}, {4, -7, 1}};
        int[] column = {9,-4, 5};
        Cramer cramer = new Cramer(matr, column);
//        Cramer cramer = Cramer.getInstance();
//        cramer.setMatrix(matr);
//        cramer.setColumn(column);
        cramer.calcMatrix();
        assertTrue(cramer.isNoSolutions());
    }
}