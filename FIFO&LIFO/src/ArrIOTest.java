import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrIOTest {

    public static void main(String[] args) {

        ArrayIO arrayIO = new ArrayIO("/home/mateusz/Downloads/array.txt","/home/mateusz/Downloads/array.txt");

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8,9));

        arrayIO.write(list,true);

        arrayIO.read().forEach(System.out::println);


    }
}
