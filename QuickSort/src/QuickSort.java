import java.util.List;

public class QuickSort {


    public static double MiddleValue(List<Integer> input) {
        double output;
        if (input.size() % 2 == 0) {
            output = ((double)(input.get((input.size() / 2) - 1) + input.get(input.size() / 2)))/2;
        } else {
            output = input.get(input.size() / 2);
        }
        return output;
    }

}
