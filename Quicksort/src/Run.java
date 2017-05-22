import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(21, "A"));
        personList.add(new Person(45, "Skalbania"));
        personList.add(new Person(21, "C"));
        personList.add(new Person(32, "Skalbania"));
        personList.add(new Person(11, "Skalbania"));
        personList.add(new Person(21, "Z"));
        personList.add(new Person(21, "H"));
        personList.add(new Person(56, "Babraj"));
        personList.add(new Person(21, "X"));

        personList = BubbleSort.sort(personList);

        for (Person person : personList) {
            System.out.println(person.getSurname() + " " + person.getAge());
        }

    }
}
