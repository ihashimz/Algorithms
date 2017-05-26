public class MyHashMap<K, V> {

    Object[] nodes = new Object[1000];

    public boolean add(K key, V value) {
        if (!checkForKeyDuplicate(key)) {
            int index = generateIndex(key);
            if (nodes[index] == null) {
                nodes[index] = new Node(key, value);
                return true;
            } else {
                Object current = nodes[index];
                while (((Node) current).next != null) {
                    current = ((Node) current).next;
                }
                ((Node) current).next = new Node(key, value);
                return true;
            }
        }
        return false;
    }

    private boolean checkForKeyDuplicate(K key) {
        int index = generateIndex(key);
        Object current = nodes[index];
        if (current != null) {
            do {
                if (((Node) current).storedKey.equals(key)) {
                    return true;
                }
                current = ((Node) current).next;
            } while (current != null);
        }
        return false;
    }

    private int generateIndex(K key) {
        int hashCode = key.hashCode() / 10000000;
        if (hashCode < 0) {
            return hashCode * -1;
        }
        return hashCode;
    }

    private class Node {
        K storedKey;
        V storedValue;
        Node next;

        public Node(K storedKey, V storedValue) {
            this.storedKey = storedKey;
            this.storedValue = storedValue;
        }
    }
}
