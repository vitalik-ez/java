package laba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void calcDeterminant_True_IfDeterminantIsValid() {
        double[][] matr = {{2,-1,0}, {-1,1,4}, {1,2,3}};
        Matrix matrix = new Matrix(matr);
        assertEquals(-17, matrix.calcDeterminant());

    }
}