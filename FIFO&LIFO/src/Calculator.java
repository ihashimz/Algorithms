import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        CalculatorIO clcIO = new CalculatorIO("/home/mateusz/Downloads/test.csv");
        clcIO.read();

        runCalc(clcIO.getInstructionsList());


    }

    //Guarantee precision if using only integers!
    public static void runCalc(List<String> instructionsList) {
        int i = 0;
        while (i < instructionsList.size() - 3) {

            Double firstNumber = Double.parseDouble(instructionsList.get(i));
            String action = instructionsList.get(i + 1);
            Double secondNumber = Double.parseDouble(instructionsList.get(i + 2));

            switch (action) {
                case "+":
                    System.out.println(firstNumber + " + " + secondNumber + " = " + add(firstNumber, secondNumber));
                    break;
                case "-":
                    System.out.println(firstNumber + " - " + secondNumber + " = " + subtract(firstNumber, secondNumber));
                    break;
                case "*":
                    System.out.println(firstNumber + " * " + secondNumber + " = " + multiply(firstNumber, secondNumber));
                    break;
                case "/":
                    System.out.println(firstNumber + " / " + secondNumber + " = " + divide(firstNumber, secondNumber));
                    break;
            }
            i += 3;
        }

    }

    //DOUBLE
    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        return x / y;
    }

    //INT
    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }
}
