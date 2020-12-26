package laba1.integration;

import laba1.Outerwear;
import laba1.RepairOuterwear;
import laba1.Size;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OuterwearIT {
    @Test
    void repair_True_IfTheMaterialHasChangedToPolyester() {
        class Dress extends Outerwear {
            public Dress(String model, String color, String material, Size size) {
                super(model, color, material, size);
            }
            @Override
            public void setPrice(double price) {}

            @Override
            public void setPrice(double price, double discount) {}
        };

        Dress obj = new Dress("classic", "brown", "sintepon", Size.EXTRA_LARGE);

        RepairOuterwear repair_obj = Mockito.mock(RepairOuterwear.class);
        Mockito.when(repair_obj.changeMaterial("sintepon")).thenReturn("polyester");

        obj.repair(repair_obj);

        assertEquals("polyester", obj.getMaterial());
        Mockito.verify(repair_obj).changeMaterial("sintepon");

    }
}
