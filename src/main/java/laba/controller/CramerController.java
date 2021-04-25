package laba.controller;

import laba.controller.commands.Command;
import laba.controller.commands.CommandFactory;
import laba.controller.commands.ExitCommand;
import laba.model.Cramer;
import laba.strategy.AddStrategy;
import laba.strategy.Context;
import laba.strategy.MultiplyStrategy;
import laba.strategy.Strategy;
import laba.view.CramerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class CramerController {
    private Cramer model;
    private CramerView view;

    @Autowired
    private Context context;

    @Autowired
    private Strategy addStrategy;

    @Autowired
    private Strategy multiplyStrategy;

    private CommandFactory commandFactory = CommandFactory.getInstance();
    private Map<String, Command> commands = new HashMap<>();

    @Autowired
    public CramerController(Cramer model, CramerView view) {
        this.model = model;
        this.view = view;
        for(String commandName : commandFactory.getCommandNames() ){
            commandFactory.createCommand(commandName)
                    .ifPresent( command -> commands.put(commandName, command) );
        }
    }

    public double[] getCramerResult() {
        return model.getResult();
    }

    public void setCramerMatrix(int[][] matrix) {
        model.setMatr(matrix);
    }
    public void setCramerColumn(int[] column) {
        model.setColumn(column);
    }
    /*
    @Autowired
    public void setContext(Context context){
        this.context = context;
    }
    @Autowired
    public void setMultiplyStrategy(Strategy multiplyStrategy){
        this.multiplyStrategy = multiplyStrategy;
    }
    @Autowired
    public void setAddStrategy(Strategy addStrategy){
        this.addStrategy = addStrategy;
    }*/

    public double[] calcCramerMatrix() {
        double[] result = model.calcMatrix();
        return result;
    }

    public void dataEntry(){
        int[][] matr = new int[3][3];
        int[] column = new int[3];

        Scanner in = new Scanner(System.in);
        for (int i=0; i < 3; i++){
            for (int j=0; j<3; j++){
                System.out.print("Input a number matr[" + i + "][" + j + "]: ");
                matr[i][j] = in.nextInt();
            }
        }
        for (int i=0; i < 3; i++){
            System.out.print("Input a column[" + i + "]: ");
            column[i] = in.nextInt();
        }
        this.setCramerMatrix(matr);
        this.setCramerColumn(column);
    }

    public void updateView() {
        view.printCramerDetails(model.getMatrix(), model.getColumn(), model.getResult());
    }
    public void changeMatrixView(int[][] matr){ view.printChangedMatrix(matr);}

    public void inputCommand(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String commandName = sc.nextLine();
        System.out.println("You have entered: " + commandName);
        if (commandName.equals("exit") || commandName.equals("calcMatrix")){
            Command command = commands.getOrDefault(commandName, ExitCommand.getInstance());
            double[] result = command.execute(model);
            this.view.printResult(result);
            System.out.println();
            System.out.print("Enter a strategy: ");
            String strategyName = sc.nextLine();
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            int[][] matr;
            if ( strategyName.equals("add") ){
                this.context.setStrategy(this.addStrategy);
                matr = this.context.executeStrategy(this.model.getMatrix(), number);
            } else {
                this.context.setStrategy(this.multiplyStrategy);
                matr = this.context.executeStrategy(this.model.getMatrix(), number);
            }
            this.changeMatrixView(matr);

        } else {
            System.out.println("You entered the wrong command: " + commandName);
        }

    }

}
