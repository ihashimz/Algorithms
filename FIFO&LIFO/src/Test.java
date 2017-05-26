public class Test {

    public static void main(String[] args) {

        LiFo<String> array = new LiFo<>();
        array.push("aa");
        array.push("bb");
        array.push("cc");
        array.push("ww");
        array.push("nn");

        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());
        System.out.println(array.pop());

        System.out.println(array.pop());

    }
}
