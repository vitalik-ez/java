package laba1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairOuterwear {

    private static Logger logger = LoggerFactory.getLogger(RepairOuterwear.class.getName());

    public String changeMaterial(String material){
        if(!material.equals("polyester")){
            material = "polyester";
            logger.info("Material change: {}", material);
        }
        return material;
    }

}
