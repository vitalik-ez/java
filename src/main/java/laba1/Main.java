package laba1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args){

        Maker maker = new Maker("CP Company - Berlin");
        List<Outerwear> outerwears = new ArrayList<>();

        outerwears.add(new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", maker));
        outerwears.add(new Jacket("gray", "cashmere", Size.LARGE,
                "casual", 300, "HOLLOFIBER", maker));
        outerwears.add(new Jacket("blue", "sintepon", Size.SMALL,
                "sport", 400, "FLEECE", maker));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 1000, maker));
        outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 860, maker));



        Iterator<Outerwear> iter = outerwears.iterator();
        while (iter.hasNext()) {
            iter.next().showDescription();
        }

        for (Outerwear outerwear : outerwears) {
            try {
                outerwear.getCheckQuality();
                logger.info("The model {} has passed the quality test!", outerwear.getModel());
            }catch(QualityException e){
                logger.info(e.getMessage());
            }finally {
                logger.info("Quality control");
            }
        }


        if(outerwears.get(1).equals(outerwears.get(2))){
            logger.info("obj_1 = obj_2");
        }else{
            logger.info("obj_1 != obj_2");
        }

        if(outerwears.get(3).equals(outerwears.get(4))){
            logger.info("obj_3 = obj_4");
        }else{
            logger.info("obj_3 != obj_4");
        }
    }
}