public class FiFo<T> {

    private Node head;
    private Node last;

    public void push(T t){
        if(head == null){
            head = new Node(t);
            last = head;
        }else {
            last.next = new Node(t);
            last = last.next;
        }
    }

    public T pop(){
        if(head != null){
            T output = head.data;
            head = head.next;
            return output;
        }
        return null;
    }

    private class Node{

        T data;
        Node next;

        private Node(T t){
            this.data = t;
        }


    }

}
