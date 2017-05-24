public class ArrayListGeneric <T>{

    private Node firstElement;
    private Node lastAdded;

    public void add(T t) {
        if(firstElement == null){
            this.firstElement = new Node(t);
            this.lastAdded = firstElement;
        }else {
           lastAdded.next = new Node(t);
           lastAdded = lastAdded.next;
        }
    }

    public T get(int i){
        int counter = 0;
        Node current = firstElement;
        while (current.next != null && counter != i){
            current = current.next;
            counter++;
        }
        return current.data;
    }

    public int size(){
        int answer = 0;
        Node current = firstElement;
        while (current != null){
            answer++;
            current = current.next;
        }
        return answer;
    }

    private class Node{

        private T data;
        private Node next;

        private Node(T data){
            this.data = data;
        }
    }
}
