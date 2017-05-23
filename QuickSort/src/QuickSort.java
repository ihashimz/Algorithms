import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public static void sort(List<Integer> list, int f, int l) {
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
    }
}
