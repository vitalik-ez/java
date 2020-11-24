package com.demo;

public class RepairOuterwear {

    public String changeMaterial(String material){
        if(!material.equals("polyester")){
            material = "polyester";
            System.out.println("Material change: " + material);
        }
        return material;
    }

}
