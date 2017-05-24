public class Test2 {

    public static void main(String[] args) {

        ArrayListGeneric<SomeObject> listGeneric = new ArrayListGeneric<>();
        listGeneric.add(new SomeObject());
        listGeneric.add(new SomeObject());
        listGeneric.add(new SomeObject());
        listGeneric.add(new SomeObject());

        System.out.println(listGeneric.size());

        System.out.println("\n----------\n");

        for(int i = 0; i < listGeneric.size(); i++){
            System.out.println(listGeneric.get(i));
        }

    }
}
