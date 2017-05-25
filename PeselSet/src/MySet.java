import java.util.HashSet;
import java.util.Set;

public class MySet<T> {

    private static int counter;
    private Node first;
    private Node lastAdded;

    public boolean add(T data) {

        if (first == null) {
            first = new Node(data);
            lastAdded = first;
            counter++;
            return true;
        }
        if (!isDuplicate(data)) {
            lastAdded.next = new Node(data);
            lastAdded = lastAdded.next;
            counter++;
            return true;
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public Set<T> getSet() {
        Node current = first;
        Set<T> set = new HashSet<>();
        set.add(current.getData());
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return set;
    }

    private boolean isDuplicate(T data) {

        Node current = first;
        do {
            if (current.getData().equals(data)) return true;
        } while ((current = current.getNext()) != null);
        return false;
    }

    private class Node {

        T data;
        Node next;

        private Node(T data) {
            this.data = data;
        }

        private T getData() {
            return this.data;
        }

        private Node getNext() {
            return this.next;
        }
    }
}
