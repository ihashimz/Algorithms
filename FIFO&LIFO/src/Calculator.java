import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        runCalc();
    }

    //Guarantee precision if using only integers!
    public static void runCalc() {
        System.out.println("Available actions: + , - , * , /");
        System.out.println("<Enter q to quit>");
        boolean onlyIntegers = true;
        Scanner sc = new Scanner(System.in);
        //variables
        Integer firstNumberI = null;
        Integer secondNumberI = null;
        Double firstNumberD = null;
        Double secondNumberD = null;

        while (true) {
            try {
                if (sc.hasNext("q")) {
                    break;
                }
                if (sc.hasNext() && sc.hasNextInt()) {
                    firstNumberI = sc.nextInt();
                } else {
                    firstNumberD = sc.nextDouble();
                    onlyIntegers = false;
                }
                String action = sc.next();
                if (sc.hasNext() && sc.hasNextInt()) {
                    secondNumberI = sc.nextInt();
                } else {
                    secondNumberD = sc.nextDouble();
                    onlyIntegers = false;
                }
                if (firstNumberD == null) {
                    firstNumberD = ((double) firstNumberI);
                }
                if (secondNumberD == null) {
                    secondNumberD = ((double) secondNumberI);
                }
                switch (action) {
                    case "+":
                        if (onlyIntegers) {
                            System.out.println(add(firstNumberI, secondNumberI));
                        } else {
                            System.out.println(add(firstNumberD, secondNumberD));
                        }
                        break;
                    case "-":
                        if (onlyIntegers) {
                            System.out.println(substract(firstNumberI, secondNumberI));
                        } else {
                            System.out.println(subtract(firstNumberD, secondNumberD));
                        }
                        break;
                    case "*":
                        if (onlyIntegers) {
                            System.out.println(multiply(firstNumberI, secondNumberI));
                        } else {
                            System.out.println(multiply(firstNumberD, secondNumberD));
                        }
                        break;
                    case "/":
                        if (onlyIntegers) {
                            System.out.println(divide(firstNumberI, secondNumberI));
                        } else {
                            System.out.println(divide(firstNumberD, secondNumberD));
                        }
                        break;
                    default:
                        System.out.println("Available actions: + , - , * , / ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input miss match?");
                sc.next();
            }
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

    public static int substract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }
}
