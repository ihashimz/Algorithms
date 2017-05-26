public class LiFo <T> {

    private Node head;
    private Node lastAdded;

    public void push(T t){
        if(head == null){
            head = new Node(t);
            lastAdded = head;
        }
        else {
            lastAdded.next = new Node(t);
            Node previous = lastAdded;
            lastAdded = lastAdded.next;
            lastAdded.previous = previous;
        }
    }

    public T pop(){
        if(head != null && lastAdded != null){
            T output = lastAdded.data;
            lastAdded = lastAdded.previous;
            return output;
        }
        return null;
    }

    private class Node{

        private T data;
        private Node previous;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
