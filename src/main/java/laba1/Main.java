package laba1;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Maker obj_maker = new Maker("CP Company - Berlin");
        List<Outerwear> Outerwears = new ArrayList<>();

        Outerwears.add(new Jacket("black", "polyester", Size.MEDIUM,
                "modern",200, "FLEECE", obj_maker));
        Outerwears.add(new Jacket("gray", "cashmere", Size.LARGE,
                "casual", 300, "HOLLOFIBER", obj_maker));
        Outerwears.add(new Jacket("blue", "sintepon", Size.SMALL,
                "sport", 400, "FLEECE", obj_maker));
        Outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 1000, obj_maker));
        Outerwears.add(new FurCoat("classic", "brown", "fur",
                Size.EXTRA_LARGE, "bear", 860, obj_maker));



        Iterator<Outerwear> iter = Outerwears.iterator();
        while (iter.hasNext()) {
            iter.next().showDescription();
        }

        for (Outerwear outerwear : Outerwears) {
            try {
                outerwear.getCheckQuality();
                System.out.println("The model " + outerwear.getModel() + " has passed the quality test!");
            }catch(QualityException e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Quality control");
            }
        }
//        for (Outerwear outerwear : Outerwears) {
//            if (!outerwear.getQuality()){
//                outerwear.repair();
//            }
//        }

        if(Outerwears.get(1).equals(Outerwears.get(2))){
            System.out.println("obj_1 = obj_2");
        }else{
            System.out.println("obj_1 != obj_2");
        }

        if(Outerwears.get(3).equals(Outerwears.get(4))){
            System.out.println("obj_3 = obj_4");
        }else{
            System.out.println("obj_3 != obj_4");
        }
    }
}