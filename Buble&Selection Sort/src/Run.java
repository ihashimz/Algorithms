import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person(21, "A", "F"));
        personList.add(new Person(21, "Q", "A"));
        personList.add(new Person(21, "B", "B"));
        personList.add(new Person(21, "B", "A"));
        personList.add(new Person(21, "B", "E"));
        personList.add(new Person(21, "G", "A"));
        personList.add(new Person(21, "Z", "C"));
        personList.add(new Person(21, "B", "D"));
        personList.add(new Person(21, "Z", "A"));

        personList.add(new Person(21, "Y", "E"));
        personList.add(new Person(21, "G", "F"));
        personList.add(new Person(2, "A", "E"));
        personList.add(new Person(21, "B", "G"));
        personList.add(new Person(1, "E", "E"));
        personList.add(new Person(5, "E", "E"));

        personList = SelectionSort.sort(personList);


        System.out.println("Sort age -> name -> surname \n");

        for (Person person : personList) {


            System.out.println("age -> " + person.getAge() +
                    " name -> " + person.getName() +
                    " surname -> " + person.getSurname()
                    );
        }
    }
}
