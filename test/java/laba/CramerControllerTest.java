package laba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class CramerControllerTest {

    @Test
    void calcCramerMatrix_True_IfMatrixCalculationIsRight() {
        Cramer cramer = Mockito.mock(Cramer.class);
        CramerView view = Mockito.mock(CramerView.class);

        double[] result = {1,2,3};
        Mockito.when(cramer.calcMatrix()).thenReturn(result);
        CramerController controller = new CramerController(cramer, view);

        assertEquals(result, controller.calcCramerMatrix());
        Mockito.verify(cramer).calcMatrix();

    }

    @Test
    void calcCramerMatrix_True_IfMatrixHasNotSolutions() {
        Cramer cramer = Mockito.mock(Cramer.class);
        CramerView view = Mockito.mock(CramerView.class);

        Mockito.when(cramer.calcMatrix()).thenReturn(null);
        CramerController controller = new CramerController(cramer, view);

        assertNull(controller.calcCramerMatrix());
        Mockito.verify(cramer).calcMatrix();

    }


}