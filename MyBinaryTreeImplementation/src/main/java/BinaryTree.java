@SuppressWarnings("ALL")
public class BinaryTree<T extends Comparable> {

    private Node<T> head;

    public void add(T content) {
        Node<T> tempNode = new Node<T>(content);
        if (head == null) {
            head = tempNode;
        } else {
            boolean done = false;
            Node current = head;
            while (!done) {
                int comparingResault = content.compareTo(current.content);
                if (comparingResault >= 1) {
                    if (current.rightSide == null) {
                        current.rightSide = new Node(content);
                        done = true;
                    } else {
                        current = current.rightSide;
                    }
                } else if (comparingResault <= -1) {
                    if (current.leftSide == null) {
                        current.leftSide = new Node(content);
                        done = true;
                    } else {
                        current = current.leftSide;
                    }
                } else {
                    throw new RuntimeException("Object already exist according to compareTo method");
                }
            }
        }
    }

    public T get(T object){
        //Not yet implemented
        return null;
    }

    public int getDepthOfTree() {
        return maxDepth(head);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int maxLeft = maxDepth(node.leftSide);
            int maxRight = maxDepth(node.rightSide);

            return Math.max(maxLeft, maxRight) + 1;
        }
    }

    public void printContentsRecursivly() {
        recurrsion(this.head);
    }

    private void recurrsion(Node current) {
        System.out.println(current.content);
        if (current.rightSide != null) recurrsion(current.rightSide);
        if (current.leftSide != null) recurrsion(current.leftSide);
    }

    private class Node<T extends Comparable> {
        private T content;
        private Node<T> leftSide;
        private Node<T> rightSide;

        public Node(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        public void setLeftSide(Node<T> leftSide) {
            this.leftSide = leftSide;
        }

        public void setRightSide(Node<T> rightSide) {
            this.rightSide = rightSide;
        }

    }
}
