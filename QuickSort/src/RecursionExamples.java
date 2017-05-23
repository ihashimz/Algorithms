public class RecursionExamples {

    public static void main(String[] args) {

        System.out.println(factorialRecursive(5));
        System.out.println(factorialIteration(5));

        System.out.println(greatestCommonDivisorRecursive(20, 16));
        System.out.println(greatestCommonDivisorIteration(20, 16));
    }

    public static long factorialRecursive(long n) {
        if (n > 1) {
            return n * factorialRecursive(n - 1);
        } else return 1;
    }

    public static long factorialIteration(long n) {
        long output = 1;
        for (int i = 2; i <= n; i++) {
            output *= i;
        }
        return output;
    }

    public static int greatestCommonDivisorRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisorRecursive(b, a % b);
        }
    }

    public static int greatestCommonDivisorIteration(int a, int b) {
        int output;
        while (b != 0) {
            output = b;
            b = a % b;
            a = output;
        }
        return a;
    }

}
