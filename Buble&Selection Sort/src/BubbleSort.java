import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public static List<Person> sort(List<Person> input) {

        List<Person> personList = new ArrayList<>(input);

        for (int j = 0; j < personList.size() - 1; j++) {
            for (int i = 0; i < personList.size() - 1; i++) {

                Person actual = personList.get(i);
                Person next = personList.get(i + 1);

                //Comparable interface way
                if (actual.compareTo(next) > 0) {
                    Collections.swap(personList, i, i + 1);
                }


                //No interface way
//                else if (actual.getAge() == next.getAge()) {
//                    int temp = actual.getSurname().compareTo(next.getSurname());
//                    if (temp > 0) {
//                        Collections.swap(personList, i, i + 1);
//                    }
//                }
            }
        }
        return personList;
    }
}
