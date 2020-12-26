package laba1.unit;

import laba1.Jacket;
import laba1.Maker;
import laba1.Size;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakerTest {

    @Test
    void getNameLocation_True_IfTheConcatenationIsCorrect() {
        Maker obj_maker = new Maker("CP Company - Berlin");
        assertEquals("CP Company - Berlin", obj_maker.getNameLocation().toString());
    }

    @Test
    void addJacket_True_IfTheSizeOfTheArrayofJacketsIsTwo() {
        Maker obj_maker = new Maker("CP Company - Berlin");
        Jacket obj_1 = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", obj_maker);
        Jacket obj_2 = new Jacket("white", "polyester", Size.MEDIUM,
                "modern",800, "FLEECE", obj_maker);

        obj_maker.addJacket(obj_1, obj_2);
        assertEquals(2, obj_maker.getJackets().length);
    }

    @Test
    void addJacket_True_IfTheSizeOfTheArrayofJacketsIsZero() {
        Maker obj_maker = new Maker("CP Company - Berlin");
        obj_maker.addJacket();
        assertEquals(0, obj_maker.getJackets().length);
    }

    @Test
    void increaseSizeJacket_True_IfTheSizeIsIncreasedCorrectly() {
        Maker maker = new Maker("CP Company - Berlin");
        Jacket jacket = Mockito.mock(Jacket.class);
        Mockito.when(jacket.increaseSize("MEDIUM")).thenReturn(Size.valueOf("LARGE"));
        assertEquals(maker.increaseSizeJacket(jacket, "MEDIUM").toString(), "Size: L");
        Mockito.verify(jacket).increaseSize("MEDIUM");
    }

}