import java.util.ArrayList;
import java.util.List;


public class Calculator {

    public static void main(String[] args) {
//        CalculatorIO clcIO = new CalculatorIO("/home/mateusz/Downloads/Calculator/input.csv",
//                "/home/mateusz/Downloads/Calculator/output.csv");
//
//        clcIO.read();
//
//        List<String> output = new ArrayList<>(runCalc(clcIO.getInstructionsList()));
//        clcIO.write(output, true);

        CalculatorIO clcIO2 = new CalculatorIO("/home/mateusz/Downloads/Calculator/output.csv",
                "/home/mateusz/Downloads/Calculator/output2.csv");
        clcIO2.read();
        List<String> list = new ArrayList<>(clcIO2.getInstructionsList());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }


    public static List<String> runCalc(List<String> instructionsList) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < instructionsList.size() - 3) {

            Double firstNumber = Double.parseDouble(instructionsList.get(i));
            output.add(instructionsList.get(i));

            String action = instructionsList.get(i + 1);
            output.add(instructionsList.get(i + 1));

            Double secondNumber = Double.parseDouble(instructionsList.get(i + 2));
            output.add(instructionsList.get(i + 2));

            switch (action) {
                case "+":
                    //System.out.println(firstNumber + " + " + secondNumber + " = " + add(firstNumber, secondNumber));
                    output.add(Double.toString(add(firstNumber, secondNumber)));
                    break;
                case "-":
                    //System.out.println(firstNumber + " - " + secondNumber + " = " + subtract(firstNumber, secondNumber));
                    output.add(Double.toString(subtract(firstNumber, secondNumber)));
                    break;
                case "*":
                    //System.out.println(firstNumber + " * " + secondNumber + " = " + multiply(firstNumber, secondNumber));
                    output.add(Double.toString(multiply(firstNumber, secondNumber)));
                    break;
                case "/":
                    //System.out.println(firstNumber + " / " + secondNumber + " = " + divide(firstNumber, secondNumber));
                    output.add(Double.toString(divide(firstNumber, secondNumber)));
                    break;
            }
            i += 3;
        }
        return output;
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

}
