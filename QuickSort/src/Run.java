public class Run {
    public static void main(String[] args) {

        MyLinkedListImplementation ls = new MyLinkedListImplementation();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");
        ls.add("6");
        ls.add("7");
        ls.add("8");
        ls.add("9");
        ls.add("10");
        ls.add("11");
        ls.add("12");

        ls.printForward();
        System.out.println("--");
        ls.printBackward();

    }
}
