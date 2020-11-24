package com.demo;

public abstract class Outerwear implements OuterwearInterface{
    private String model;
    private String color;
    private String material;
    private Size size;
    protected boolean quality;
    protected double price;

    public Outerwear(String model, String color, String material, Size size){
        this.model = model;
        this.color = color;
        this.material = material;
        this.size = size;
    }

    public boolean getCheckQuality() throws QualityException{
//        Random random_quality = new Random();
//        quality = random_quality.nextBoolean();
        quality = false;
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
        System.out.println("Model: " + model);
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
        System.out.println(size);
        System.out.println("Number: " + size.getNum());
    }
    public String getModel(){
        return model;
    }
    public String getColor() { return color; }
    public String getMaterial() { return material; }
    public Size getSize(){ return size; }
    public double getPrice(){ return price; }
    public boolean getQuality(){ return quality; }

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

    public abstract void setPrice(double price);
    public abstract void setPrice(double price, double discount);

}
