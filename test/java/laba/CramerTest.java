package laba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CramerTest {

    @Test
    void calcMatrix_True_IfMatrixCalculationIsRight() {
        double[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
        double[] column = {0,13,14};
        Cramer cramer = new Cramer(matr, column);
        cramer.calcMatrix();
        double[] expected_result = {1,2,3};
        assertArrayEquals(expected_result, cramer.getResult());
    }

    @Test
    void calcMatrix_True_IfMatrixHasNotSolutions() {
        double[][] matr = {{2,-1,3}, {3, -5, 1}, {4, -7, 1}};
        double[] column = {9,-4, 5};
        Cramer cramer = new Cramer(matr, column);
        cramer.calcMatrix();
        assertTrue(cramer.isNoSolutions());
    }
}