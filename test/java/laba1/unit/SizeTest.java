package laba1.unit;

import laba1.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    @Test
    void ToString_True_IfTheConcatenationIsCorrect() {
        Size size = Size.EXTRA_SMALL;
        assertEquals("Size: XS", size.toString());
    }
}