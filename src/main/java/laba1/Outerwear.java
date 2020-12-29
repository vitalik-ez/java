package laba1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public abstract class Outerwear implements OuterwearInterface{
    private String model;
    private String color;
    private String material;
    private Size size;
    private Maker maker;
    protected boolean quality;
    protected double price;
    private static Logger logger = LoggerFactory.getLogger(Outerwear.class.getName());

    protected Outerwear(String model, String color, String material, Size size){
        this.model = model;
        this.color = color;
        this.material = material;
        this.size = size;
    }

    protected Outerwear(String model, String color, String material, Size size, Maker maker){
        this.model = model;
        this.color = color;
        this.material = material;
        this.size = size;
        this.maker = maker;
    }


    public boolean getCheckQuality() throws QualityException{
        quality = new Random().nextBoolean();
        if(!quality){
            throw new QualityException("The model " + model + " hasn't passed the quality test");
        }
        return quality;
    }
    public void repair(RepairOuterwear repair){
        setMaterial(repair.changeMaterial(getMaterial()));
        quality = true;
    }

    public void showDescription(){
        logger.info("Model: {}", model);
        logger.info("Material: {}", material);
        logger.info("Color: {}", color);
        logger.info("Number: {}", size.getNum());
    }
    public String getModel(){
        return model;
    }
    public String getColor() { return color; }
    public String getMaterial() { return material; }
    public Size getSize(){ return size; }
    public double getPrice(){ return price; }
    public boolean getQuality(){ return quality; }
    public Maker getMaker(){ return maker; }

    public void setModel(String model){
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getMaterial();
    }
}
