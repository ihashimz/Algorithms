import java.util.HashSet;
import java.util.Set;

public class MyTreeSet {

    private Set<String> peselSet = new HashSet<>();

    private Node[] heads = new Node[10];
    private static int counter = 0;

    public boolean add(String id){
        if(!isDuplicate(id)){
            addToTree(id);
            peselSet.add(id);
            counter++;
            return true;
        }
        return false;
    }

    public Set<String> getEntries(){
        return new HashSet<>(peselSet);
    }

    private boolean addToTree(String id) {

        int[] idInts = convertToInts(id);

        int q = 0;
        Node[] temp = heads;

        for (int i = 0; i < 10; i++) {

            if (temp[idInts[q]] == null) {
                temp[idInts[q]] = new Node();
            }
            if (q == 9) {
                temp = temp[idInts[q++]].nexts;
                temp[idInts[q]] = new Node();
                temp[idInts[q]].setUsed(true);
                return true;
            }
            temp = temp[idInts[q++]].nexts;

        }
        return false;
    }

    private boolean isDuplicate(String id) {

        int[] idInts = convertToInts(id);

        int q = 0;
        Node[] temp = heads;

        for (int i = 0; i < 10; i++) {

            if (temp[idInts[q]] == null) {
                return false;
            }

            if (q == 9) {
                temp = temp[idInts[q++]].nexts;
                if (temp == null) return false;
                return temp[idInts[q]].isUsed();
            }
            temp = temp[idInts[q++]].nexts;
        }
        return true;
    }

    private int[] convertToInts(String input) {
        char[] idChar = input.toCharArray();
        int[] idInts = new int[11];
        for (int i = 0; i < idInts.length; i++) {
            idInts[i] = Character.getNumericValue(idChar[i]);
        }
        return idInts;
    }

//////////////////////////
//    public void testShowAll() {
//        testShowAll(heads);
//    }
//
//    private void testShowAll(Node[] nodes) {
//
//        for (Node node : nodes) {
//            if (node != null) {
//                if (node.getPesel() != null) {
//                    System.out.println(node.getPesel());
//                }
//                if (node.nexts != null && node.nexts.length != 0) {
//                    testShowAll(node.nexts);
//                }
//            }
//        }
//    }
/////////////////////////


    private class Node {
        boolean used = false;
        private Node[] nexts = new Node[10];

        public void setUsed(boolean used) {
            this.used = used;
        }

        public boolean isUsed() {
            return used;
        }
    }

}
