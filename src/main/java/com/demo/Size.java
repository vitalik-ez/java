package com.demo;

public enum Size {
    EXTRA_SMALL("XS", 5),
    SMALL("S", 2),
    MEDIUM("M", 3),
    LARGE("L", 6),
    EXTRA_LARGE("XL", 2);

    private String indicator;
    private int num;

    Size(String indicator, int num) {
        this.indicator = indicator;
        this.num = num;
    }
    public int getNum(){
        return num;
    }

    @Override
    public String toString() {
        return "Size: " + indicator;
    }
}
