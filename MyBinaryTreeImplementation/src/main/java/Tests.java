public class Tests {
    public static void main(String[] args) {

        BinaryTree<String> myBinaryTree = new BinaryTree<String>();

        myBinaryTree.add("dudek");
        myBinaryTree.add("dupa");
        myBinaryTree.add("browar");
        myBinaryTree.add("siema");

        myBinaryTree.printContentsRecursivly();

        System.out.println(myBinaryTree.getDepthOfTree());
        System.out.println();
    }
}
