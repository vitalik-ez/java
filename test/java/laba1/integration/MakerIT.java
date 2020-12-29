package laba1.integration;

import laba1.Jacket;
import laba1.Maker;
import laba1.Size;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakerIT {
    @Test
    void increaseSizeJacket_True_IfTheSizeIsIncreasedCorrectly() {
        Maker maker = new Maker("CP Company - Berlin");
        Jacket jacket = Mockito.mock(Jacket.class);
        Mockito.when(jacket.increaseSize("MEDIUM")).thenReturn(Size.valueOf("LARGE"));
        assertEquals("Size: L", maker.increaseSizeJacket(jacket, "MEDIUM").toString());
        Mockito.verify(jacket).increaseSize("MEDIUM");
    }
}
