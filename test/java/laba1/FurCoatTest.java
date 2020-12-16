package laba1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FurCoatTest {

    @Test
    void setPrice_True_IfFurBear() {
        FurCoat obj = new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 1000);
        obj.setPrice(900,50);
        assertEquals(630, obj.getPrice());
    }


    @Test
    void setPrice_True_IfFurNotBear() {
        FurCoat obj = new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "fox", 1000);
        obj.setPrice(1200,50);
        assertEquals(600, obj.getPrice());
    }

    @Test
    void setPrice_True_IfInvalidDiscount() {
        FurCoat obj = new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "fox", 1000);
        obj.setPrice(700,-20);
        assertEquals(1000, obj.getPrice());
    }
}