package com.demo;

public interface OuterwearInterface {
    String getModel();
    String getColor();
    String getMaterial();
    Size getSize();

    void setModel(String model);
    void setColor(String color);
    void setMaterial(String material);
    void setSize(Size size);

    void setPrice(double price);
    void setPrice(double price, double discount);

    void repair(RepairOuterwear repair);

    boolean getCheckQuality() throws QualityException;
}
