import java.util.HashSet;
import java.util.Set;

public class Tests {

    public static void main(String[] args) {
        Node node1 = new Node("xx");
        Node node2 = new Node("dd");
        Node node3 = new Node("cc");
        Node node4 = new Node("aa");
        Node node5 = new Node("zz");
        Set<Node> nodes1 = new HashSet<>();
        Set<Node> nodes2 = new HashSet<>();

        node1.setNext(nodes1);
        node2.setNext(nodes2);

        nodes1.add(node2);
        nodes1.add(node3);
        nodes2.add(node4);
        nodes2.add(node5);

        System.out.println("WAY 1");
        Node.showAll(node1);
        System.out.println("WAY 2");
        Node.showAll2(node1);

    }

}
