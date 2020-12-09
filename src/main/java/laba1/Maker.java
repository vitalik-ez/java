package laba1;

import java.util.*;

import static java.util.Optional.ofNullable;

public class Maker{
    private String name;
    private String location;
    private Jacket[] jackets;

    public Maker(String data){
        String[] name_location = data.split(" - ");
        name = name_location[0];
        location = name_location[1];
    }
    public void addJacket(Jacket ...arr_jacket){
        if(arr_jacket.length != 0){
            jackets = arr_jacket;
        }else{
            jackets = new Jacket[0];
        }
    }
    public StringBuilder getNameLocation(){
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" - ").append(location);
    }

    public Size increaseSizeJacket(Jacket jacket, String size){
        return jacket.increaseSize(size);
    }

    public Optional<Double> getTotalCostJackets(List<Outerwear> outerwears){
        return ofNullable(outerwears)
                .map(s -> s.stream()
                    .filter(c -> !c.getMaterial().equals("fur"))
                    .mapToDouble(Outerwear::getPrice)
                    .sum()
                );
    }



    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public Jacket[] getJackets(){ return jackets; }

}
