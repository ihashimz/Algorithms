import java.util.Set;

public class Node {

    private Object data;
    private Set<Node> next;

    Node(Object o) {
        this.data = o;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Set<Node> set) {
        this.next = set;
    }

    public Object getData() {
        return this.data;
    }

    public Set<Node> getNext() {
        return this.next;
    }

    public static void showAll(Node head) {
        Node current = head;
        for (Node node : current.next) {
            System.out.println(node.getData());
            if (node.getNext() != null) {
                showAll(node);
            }
        }
    }

    public static void showAll2(Node head) {
        Node current = head;
        System.out.println(current.getData());
        Set<Node> nexts = current.next;
        if (nexts != null && (!nexts.isEmpty())) {
            for (Node node : nexts) {
                showAll2(node);
            }
        }
    }

}

