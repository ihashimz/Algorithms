import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public static List<Person> sort(List<Person> input) {

        List<Person> output = new ArrayList<>(input);

        for(int i = 0; i < output.size(); i++){
            int currentMinIndex = findMinIndex(i,output);
            Collections.swap(output,i,currentMinIndex);
        }
        return output;
    }

    private static int findMinIndex(int from,List<Person> inputList) {
        List<Person> sublist = new ArrayList<>(inputList.subList(from,inputList.size()));
        return inputList.indexOf(Collections.min(sublist));
    }


}
