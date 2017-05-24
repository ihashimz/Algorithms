import java.util.HashSet;
import java.util.Set;

public class Tests {

    public static void main(String[] args) {
        TreeList node1 = new TreeList("xx");
        TreeList node2 = new TreeList("dd");
        TreeList node3 = new TreeList("cc");
        TreeList node4 = new TreeList("aa");
        TreeList node5 = new TreeList("zz");
        Set<TreeList> nodes1 = new HashSet<>();
        Set<TreeList> nodes2 = new HashSet<>();

        node1.setNext(nodes1);
        node2.setNext(nodes2);

        nodes1.add(node2);
        nodes1.add(node3);
        nodes2.add(node4);
        nodes2.add(node5);

        System.out.println("WAY 1");
        TreeList.showAllRecursive(node1);
        System.out.println("WAY 2");
        TreeList.showAllRecursive2(node1);
        System.out.println("WAY 3");
        TreeList.showAllRecursiveIterator(node1);


    }

}
