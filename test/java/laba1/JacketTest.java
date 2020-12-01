package laba1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JacketTest {

    @Test
    void equals_True_IfTheJacketsAreTheSame() {
        Maker obj_maker = new Maker("CP Company - Berlin");
        Jacket obj_1 = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", obj_maker);
        Jacket obj_2 = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", obj_maker);
        assertTrue(obj_2.equals(obj_1));
    }

    @Test
    void equals_False_IfTheJacketsAreDifferent() {
        Maker obj_maker = new Maker("CP Company - Berlin");
        Jacket obj_1 = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", obj_maker);
        Jacket obj_2 = new Jacket("white", "polyester", Size.MEDIUM,
                "modern",800, "FLEECE", obj_maker);
        assertFalse(obj_1.equals(obj_2));
    }

    @Test
    void setPrice_True_IfInvalidPrice() {
        Jacket obj = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE");
        obj.setPrice(-500,20);
        assertEquals(200, obj.getPrice());
    }


    @Test
    void setPrice_True_IfInvalidDiscount() {
        Jacket obj = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE");
        obj.setPrice(1000,-20);
        assertEquals(200, obj.getPrice());
    }

    @Test
    void setPrice_True_IfValidDiscount() {
        Jacket obj = new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE");
        obj.setPrice(1000,20);
        assertEquals(800, obj.getPrice());
    }

    @Test
    void increaseSize_True_IfTheSizeIsIncreasedCorrectly() {
        Jacket obj = new Jacket("black", "polyester", Size.LARGE,
                "modern",200, "FLEECE");

        assertEquals(obj.increaseSize("LARGE").toString(), "Size: XL");
        assertEquals(obj.increaseSize("EXTRA_LARGE").toString(), "Size: XL");
    }
}