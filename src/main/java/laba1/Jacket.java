package laba1;

public class Jacket extends Outerwear{
    private Insulation obj_insulation;

    public Jacket(String color, String material, Size size, String model, int price, String type_insulation){
        super(model, color, material, size);
        this.price = price;
        obj_insulation = new Insulation(type_insulation);
        quality = false;
    }

    public Jacket(String color, String material, Size size, String model, int price, String type_insulation, Maker maker){
        super(model, color, material, size, maker);
        this.price = price;
        obj_insulation = new Insulation(type_insulation);
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
        int num_size = Size.valueOf(size).ordinal();
        if(num_size < 4){
            setSize(Size.values()[num_size + 1]);
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
        if(!obj_insulation.typeInsulation.equals(jacket.obj_insulation.typeInsulation)){
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

    public void showDescription(){
        super.showDescription();
        System.out.println("Insulation: " + obj_insulation.getTypeInsulation());
        System.out.println("Price: " + price);
        System.out.println();
    }


}
