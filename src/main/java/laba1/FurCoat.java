package laba1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurCoat extends Outerwear{
    private static Logger logger = LoggerFactory.getLogger(FurCoat.class.getName());
    private String fur;

    public FurCoat(String model, String color, String material, Size size, String fur, int price){
        super(model, color, material, size);
        this.fur = fur;
        this.price = price;
        quality = false;
    }

    public FurCoat(String model, String color, String material, Size size, String fur, int price, Maker maker){
        super(model, color, material, size, maker);
        this.fur = fur;
        this.price = price;
        quality = false;
    }

    String getFur(){
        return fur;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setPrice(double price, double discount){
        if(discount < 0 || discount > 100 || price < 0){
            return;
        }
        if(fur.equals("bear")){
            this.price = price - price * 0.3;
        }else{
            this.price = price - price * discount/100;
        }
    }

    @Override
    public void showDescription(){
        super.showDescription();
        logger.info("Fur: {} ", fur);
        logger.info("Price: {}", price);
    }

}
