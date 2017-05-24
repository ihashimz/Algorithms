import java.util.HashSet;
import java.util.Set;

public class TreeList {
    private Node head = null;

    public void add() {

    }

    private class Node {

        private String name;
        private Node parent;
        private Set<Node> branchList;

        private Node(String name, Node parent, Set<Node> nodes) {
            this.name = name;
            this.parent = parent;
            this.branchList = new HashSet<>(nodes);
        }

        private void addKid(Node kid){

        }
    }
}
