import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public static List<Person> sort(List<Person> input) {

        List<Person> personList = new ArrayList<>(input);

        int k;
        for (int i = 0; i < personList.size(); i++) {
            k = i;
            for (int j = i + 1; j < personList.size(); j++) {
                if (personList.get(j).getAge() < personList.get(k).getAge()) {
                    k = j;
                }
            }
            Collections.swap(personList, k, i);
        }
        return personList;
    }

}
