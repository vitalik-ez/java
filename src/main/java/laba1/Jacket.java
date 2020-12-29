package laba1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jacket extends Outerwear{

    private static Logger logger = LoggerFactory.getLogger(Jacket.class.getName());
    private Insulation insulation;

    public Jacket(String color, String material, Size size, String model, int price, String insulation){
        super(model, color, material, size);
        this.price = price;
        this.insulation = new Insulation(insulation);
        quality = false;
    }

    public Jacket(String color, String material, Size size, String model, int price, String insulation, Maker maker){
        super(model, color, material, size, maker);
        this.price = price;
        this.insulation = new Insulation(insulation);
        quality = false;
    }

    private class Insulation{
        private String typeInsulation;

        public Insulation(String typeInsulation){
            this.typeInsulation = typeInsulation;
        }

        public String getTypeInsulation(){
            return typeInsulation;
        }
        void setTypeInsulation(String typeInsulation){
            this.typeInsulation = typeInsulation;
        }

    }

    public Size increaseSize(String size){
        int numSize = Size.valueOf(size).ordinal();
        if(numSize < 4){
            setSize(Size.values()[numSize + 1]);
        }
        return getSize();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Jacket jacket = (Jacket) obj;
        if (!getColor().equals(jacket.getColor())){
            return false;
        }
        if (getSize() != jacket.getSize()){
            return false;
        }
        if(!getMaterial().equals(jacket.getMaterial())){
            return false;
        }
        if(price != jacket.price){
            return false;
        }
        if(!insulation.typeInsulation.equals(jacket.insulation.typeInsulation)){
            return false;
        }
        return getModel().equals(jacket.getModel());
    }

    public void setPrice(double price){
        this.price = price;
    }
    public void setPrice(double price, double discount){
        if(discount < 0 || discount > 100 || price < 0){
            return;
        }
        this.price = price - price * discount/100;
    }

    @Override
    public void showDescription(){
        super.showDescription();
        logger.info("Insulation: {}", insulation.getTypeInsulation());
        logger.info("Price: {}", price);

    }


}
