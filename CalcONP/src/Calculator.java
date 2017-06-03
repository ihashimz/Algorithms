import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    //First attempt partial working
    private static List<String> convertToONP(String input) {

        String[] inputList = input.split(" ");

        Stack<String> actions = new Stack<>();

        List<String> output = new ArrayList<>();

        for (String string : inputList) {
            try {
                Double i = Double.parseDouble(string);
                output.add(i.toString());
            } catch (NumberFormatException e) {
                if (!actions.isEmpty()) {
                    String action = actions.pop();
                    if (action.equals(")")) {
                        action = actions.pop();
                        while (!action.equals("(")) {
                            output.add(action);
                            if (!actions.isEmpty()) {
                                action = actions.pop();
                            } else break;
                        }
                    } else if (getPriority(action) > getPriority(string) || action.equals("(")) {
                        actions.push(action);
                        actions.push(string);

                    } else {

                        while (getPriority(action) < getPriority(string)) {
                            if (!actions.isEmpty()) {
                                output.add(action);
                                action = actions.pop();
                            } else break;
                        }
                        actions.push(action);
                        actions.push(string);
                    }
                } else {
                    actions.push(string);
                }
            }
        }
        for (
                int i = 0;
                i <= actions.size(); i++)

        {
            output.add(actions.pop());
        }
        return output;
    }

    //Second one seems to be working fine
    private static List<String> convertToONP2(String input) {

        String[] inputList = spaceSeparator(input).split(" ");

        Stack<String> actions = new Stack<>();

        List<String> output = new ArrayList<>();

        for (String string : inputList) {
            if (string.matches("\\d+")) {
                output.add(string);
            } else {
                if (actions.isEmpty()) {
                    actions.add(string);
                } else {
                    if (string.equals("(")) {
                        actions.add(string);
                    } else if (string.equals(")")) {
                        String tempAction = actions.pop();
                        while (!tempAction.equals("(")) {
                            output.add(tempAction);
                            if (!actions.isEmpty()) {
                                tempAction = actions.pop();
                            } else break;
                        }
                    } else {
                        if (!actions.isEmpty()) {
                            String tempAction = actions.pop();
                            if (tempAction.equals("(") || getPriority(string) > getPriority(tempAction)) {
                                actions.push(tempAction);
                                actions.push(string);

                            } else {
                                while (getPriority(tempAction) > getPriority(string)) {
                                    output.add(tempAction);
                                    if (!actions.isEmpty()) {
                                        tempAction = actions.pop();
                                        actions.push(tempAction);
                                    } else break;
                                }
                                actions.push(string);
                            }
                        }
                    }
                }
            }
        }
        int size = actions.size();
        while ((size--) != 0) {
            output.add(actions.pop());
        }
        return output;
    }

    public static double getResult(String input) {

        List<String> onp = convertToONP2(input);
        Stack<String> actions = new Stack<>();

        for (String string : onp) {

            if (string.matches("\\d+")) {
                actions.add(string);
            } else {
                double firstNumber = Double.parseDouble(actions.pop());
                double secondNumber = Double.parseDouble(actions.pop());
                actions.push(String.valueOf(calculate(string,secondNumber,firstNumber)));
            }
        }
        return Double.parseDouble(actions.lastElement());
    }

    private static String spaceSeparator(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            String currentSub = input.substring(i, i + 1);
            if (currentSub.matches("\\d")) {
                output = output.concat(currentSub);
            } else {
                if (i == 0 || !input.substring(i - 1, i).matches("\\d")) {
                    output = output.concat(currentSub + " ");
                } else if (i == input.length() - 1) {
                    output = output.concat(" " + currentSub);
                } else {
                    output = output.concat(" " + currentSub + " ");
                }
            }
        }
        return output;
    }

    private static int getPriority(String i) {
        switch (i) {
            case "^":
                return 5;
            case "*":
                return 4;
            case "/":
                return 3;
            case "+":
                return 2;
            case "-":
                return 1;
        }
        return -1;
    }

    private static double calculate(String operation, double first, double second) {
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "^":
                return Math.pow(first,second);
        }
        return Double.MIN_VALUE;
    }

    public static void debug(String input){
        System.out.println("//input " + input);
        System.out.println("//separated " + spaceSeparator(input));
        System.out.print("//converted ");
        convertToONP2(input).forEach(s -> System.out.print(s + " "));
        System.out.println("\n//calculated " + getResult(input));

    }
}
