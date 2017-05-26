public class MySet2 {

    Node[] heads = new Node[10];

    public boolean add(String id) {

        char[] idChar = id.toCharArray();
        int[] idInts = new int[11];
        for (int i = 0; i < idInts.length; i++) {
            idInts[i] = Character.getNumericValue(idChar[i]);
        }

        int q = 0;
        Node[] temp = heads;

        for (int i = 0; i < 10; i++) {

            if (temp[idInts[q]] == null) {
                temp[idInts[q]] = new Node();
            }
            if (q == 9) {
                temp = temp[idInts[q++]].nexts;
                temp[idInts[q]] = new Node();
                temp[idInts[q]].setPesel(id);
                return true;
            }
            temp = temp[idInts[q++]].nexts;

        }
        return false;
    }


    public void testShowAll() {
        testShowAll(heads);
    }

    private void testShowAll(Node[] nodes) {

        for (Node node : nodes) {
            if (node != null) {
                if (node.getPesel() != null) {
                    System.out.println(node.getPesel());
                }
                if (node.nexts != null && node.nexts.length != 0) {
                    testShowAll(node.nexts);
                }
            }
        }


    }

    private class Node {
        private String pesel;
        private Node[] nexts = new Node[10];

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }

        public String getPesel() {
            return pesel;
        }
    }

}
