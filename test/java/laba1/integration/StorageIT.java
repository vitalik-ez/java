package laba1.integration;

import laba1.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageIT {

    @Test
    void getTotalCostJackets_True_ifTotalCostJacketsIsRight(){
        List<Outerwear> outerwears = new ArrayList<>();
        Maker maker = new Maker("CP Company - London");
        outerwears.add(new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", maker));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 1000, maker));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 860, maker));

        Storage storage = new Storage(outerwears);
        Storage spyStorage = Mockito.spy(storage);

        Mockito.when(spyStorage.getTotalCostJackets()).thenReturn(200.0);

        assertEquals(200.0, spyStorage.getTotalCostJackets());
        Mockito.verify(spyStorage).getTotalCostJackets();

    }
}
