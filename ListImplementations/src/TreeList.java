import java.util.Iterator;
import java.util.Set;

public class TreeList {

    private Object data;
    private Set<TreeList> next;

    TreeList(Object o) {
        this.data = o;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Set<TreeList> set) {
        this.next = set;
    }

    public Object getData() {
        return this.data;
    }

    public Set<TreeList> getNext() {
        return this.next;
    }

    public static void showAllRecursive(TreeList head) {
        for (TreeList node : head.next) {
            System.out.println(node.getData());
            if (node.getNext() != null) {
                showAllRecursive(node);
            }
        }
    }

    public static void showAllRecursive2(TreeList head) {
        System.out.println(head.getData());
        Set<TreeList> nexts = head.next;
        if (nexts != null && (!nexts.isEmpty())) {
            for (TreeList node : nexts) {
                showAllRecursive2(node);
            }
        }
    }

    public static void showAllRecursiveIterator(TreeList head) {
        System.out.println(head.getData());
        if (head.getNext() != null) {
            Iterator iterator = head.getNext().iterator();
            while (iterator.hasNext()) {
                showAllRecursiveIterator(((TreeList) iterator.next()));
            }
        }
    }
}

