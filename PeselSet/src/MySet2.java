public class MySet2 {

    Node[] heads = new Node[10];

    public boolean add(String id) {

        char[] idChar = id.toCharArray();
        int[] idInts = new int[11];
        for (int i = 0; i < idInts.length; i++){
            idInts[i] = Character.getNumericValue(idChar[i]);
        }

        int q = 0;
        for(int i = 0; i < 11; i++){

            Node current = heads[idInts[q]];
            if(current == null){
                current = new Node();
            }
            current = current.nexts[idInts[i]];

        }
        return true;
    }

    private class Node {
        private String pesel;
        private Node[] nexts = new Node[10];

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }
    }

    private class Id {
        String number;

        public Id(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }
    }
}
