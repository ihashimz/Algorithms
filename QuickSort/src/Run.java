import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(7);
        list.add(5);
        list.add(9);
        list.add(10);

        System.out.println(QuickSort.MiddleValue(list));
    }
}
