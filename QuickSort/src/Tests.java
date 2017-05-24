import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {

        MyLinkedListImplementation ls = new MyLinkedListImplementation();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");
        ls.add("6");
        ls.add("7");
        ls.add("8");
        ls.add("9");
        ls.add("10");
        ls.add("11");
        ls.add("12");

        ls.printForward();
        System.out.println("--");
        ls.printBackward();
        System.out.println("\n\n");
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(3);

        list = QuickSort.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
