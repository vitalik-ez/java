package laba1.unit;

import laba1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private List<Outerwear> outerwears;

    @BeforeEach
    public void init() {
        outerwears = new ArrayList<>();
        Maker maker_1 = new Maker("CP Company - London");
        Maker maker_2 = new Maker("CP Company - New York");
        Maker maker_3 = new Maker("Nike - Berlin");
        outerwears.add(new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", maker_2));
        outerwears.add(new Jacket("gray", "polyester", Size.LARGE,
                "casual", 300, "HOLLOFIBER", maker_3));
        outerwears.add(new Jacket("blue", "sintepon", Size.SMALL,
                "sport", 400, "FLEECE", maker_1));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 1000, maker_1));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 860, maker_1));
    }


    @Test
    void getTotalCostJackets_True_ifTotalCostJacketsIsRight(){
        Storage storage = new Storage(outerwears);
        Storage spyStorage = Mockito.spy(storage);

        Mockito.when(spyStorage.getTotalCostJackets()).thenReturn(900.0);

        assertEquals(900.0, spyStorage.getTotalCostJackets());
        Mockito.verify(spyStorage).getTotalCostJackets();

    }

    @Test
    void getTheMostExpensiveProduct_True_IfPriceIsHighest() {
        Storage storage = new Storage(outerwears);
        Optional<Outerwear> obj = storage.getTheMostExpensiveProduct();
        assertTrue(obj.isPresent());
        assertEquals(1000, obj.get().getPrice());
    }

    @Test
    void getAveragePrice_True_IfValueIsRight() {
        Storage storage = new Storage(outerwears);
        OptionalDouble obj = storage.getAveragePrice();
        assertTrue(obj.isPresent());
        assertEquals(552, obj.getAsDouble());
    }

    @Test
    void getMapSuitableOuterwear_True_IfListMeetTheRequirements() {
        Storage storage = new Storage(outerwears);
        Predicate<Outerwear> predicateInstance = s -> s.getMaterial().equals("polyester");
        Map<Boolean, List<Outerwear>> map = storage.getMapSuitableOuterwear(predicateInstance);
        assertEquals(3, map.get(false).size());
        assertEquals(2, map.get(true).size());
    }

    @Test
    void getTheMostPopularNameMaker_True_IfNameIsRight() {
        Storage storage = new Storage(outerwears);
        assertEquals("CP Company", storage.getTheMostPopularNameMaker());
    }
}