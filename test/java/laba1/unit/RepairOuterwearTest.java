package laba1.unit;

import laba1.Jacket;
import laba1.RepairOuterwear;
import laba1.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepairOuterwearTest {

    @Test
    void changeMaterial_True_IfTheMaterialHasChangedToPolyester() {
        Jacket obj = new Jacket("black", "sintepon", Size.MEDIUM,
                "modern",200, "FLEECE");

        RepairOuterwear repair = new RepairOuterwear();
        assertEquals("polyester", repair.changeMaterial(obj.getMaterial()));
    }

    @Test
    void changeMaterial_True_IfTheMaterialPolyester() {
        Jacket obj = new Jacket("white", "polyester", Size.LARGE,
                "modern",450, "FLEECE");

        RepairOuterwear repair = new RepairOuterwear();
        assertEquals("polyester", repair.changeMaterial(obj.getMaterial()));
    }

}