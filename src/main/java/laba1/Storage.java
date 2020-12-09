package laba1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Storage {
    private List<Outerwear> outerwears;

    public Storage(List<Outerwear> outerwears){
        this.outerwears = outerwears;
    }

    public double getTotalCostJackets(){
        return outerwears.stream()
                .filter(c -> !c.getMaterial().equals("fur"))
                .mapToDouble(Outerwear::getPrice)
                .sum();
    }

    public Optional<Outerwear> getTheMostExpensiveProduct(){
        return outerwears.stream()
                .max(Comparator.comparingDouble(Outerwear::getPrice));
    }

    public OptionalDouble getAveragePrice(){
        return outerwears.stream()
                .mapToDouble(Outerwear::getPrice)
                .average();
    }

    public Map<Boolean, List<Outerwear>> getMapSuitableOuterwear(Predicate<Outerwear> predicateInstance){
        return outerwears.stream().
                collect(Collectors.partitioningBy(predicateInstance));
    }

    public String getTheMostPopularNameMaker(){
        return outerwears.stream()
                .map(Outerwear::getMaker)
                .collect(Collectors.groupingBy(Maker::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }



}
