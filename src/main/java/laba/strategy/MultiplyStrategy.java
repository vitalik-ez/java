package laba.strategy;

import org.springframework.stereotype.Component;

@Component
public class MultiplyStrategy implements Strategy {

    @Override
    public int[][] execute(int[][] matr, int number) {
        System.out.println("Strategy pattern multiply");
        for (int i=0; i<matr.length; i++){
            for (int j=0; j< matr.length; j++){
                matr[i][j] *= number;
            }
        }
        return matr;
    }
}
