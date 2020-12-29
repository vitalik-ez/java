package laba1;

import java.util.*;

public class Maker{
    private String name;
    private String location;
    private Jacket[] jackets;
    private ArrayList<String> names;

    public Maker(String data){
        String[] nameLocation = data.split(" - ");
        name = nameLocation[0];
        location = nameLocation[1];
        names = new ArrayList<>();
        names.add(nameLocation[0]);
        names.add(nameLocation[1]);
    }
    public void addJacket(Jacket ...jacket){
        if(jacket.length != 0){
            jackets = jacket;
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


    public String getName(){
        return name;
    }
    public List<String> getNames(){
        return names;
    }
    public String getLocation(){
        return location;
    }
    public Jacket[] getJackets(){ return jackets; }

}
