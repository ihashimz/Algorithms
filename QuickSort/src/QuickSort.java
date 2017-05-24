import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> temp = new ArrayList<>(list);
        QuickSort.sort(temp, 0, temp.size() - 1);
        return temp;
    }

    private static void sort(List<Integer> list, int f, int l) {
        int firstIndex = f;
        int lastIndex = l;
        int dividerValue = list.get((l + f) / 2);
        do {
            while (list.get(firstIndex) < dividerValue) {
                firstIndex++;
            }
            while (list.get(lastIndex) > dividerValue) {
                lastIndex--;
            }
            if (firstIndex <= lastIndex) {
                Collections.swap(list, firstIndex, lastIndex);
                firstIndex++;
                lastIndex--;
            }
        } while (firstIndex <= lastIndex);
        if (lastIndex > f) {
            sort(list, f, lastIndex);
        }
        if (firstIndex < l) {
            sort(list, firstIndex, l);
        }
    }
}
