package laba.strategy;

import laba.strategy.Strategy;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int[][] executeStrategy(int[][] matr, int number){
        return strategy.execute(matr, number);
    }

}
