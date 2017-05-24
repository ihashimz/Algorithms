public class LinkedList {
    private Node firstNode = null;
    private Node lastNode = null;

    public void add(String name) {
        if (firstNode == null) {
            firstNode = new Node(name, null, null);
            lastNode = firstNode;
        } else {
            lastNode.next = new Node(name, lastNode, null);
            lastNode = lastNode.next;
        }
    }

    public void printForward() {
        Node current = firstNode;
        while (current != null) {
            System.out.println(current.getName());
            current = current.getNext();
        }
    }

    public void printBackward() {
        Node current = lastNode;
        while (current != null) {
            System.out.println(current.getName());
            current = current.getPrevious();
        }
    }

    private class Node {

        private String name;
        private Node next = null;
        private Node previous = null;

        private Node(String name, Node previous, Node next) {
            this.name = name;
            this.next = next;
            this.previous = previous;
        }

        private String getName() {
            return name;
        }

        public Node getPrevious() {
            return previous;
        }

        private Node getNext() {
            return next;
        }
    }



}
