import java.util.Set;

public class Test {

    public static void main(String[] args) {

        MyTreeSet ms = new MyTreeSet();
        ms.add("96030804730");
        ms.add("96030804710");
        ms.add("16031804730");
        ms.add("95030804730");
        ms.add("96530804710");
        ms.add("96061804730");
        ms.add("96070804730");
        ms.add("96830804710");
        ms.add("96331804730");

        printPeselNumbers(ms.getEntries());
        System.out.println(ms.getEntries().size());


//        PeselSet ps = new PeselSet();
//
//        try {
//        System.out.println(ps.addPesel("96030804730"));
//            System.out.println(ps.addPesel("96030804730"));//DUPLICATE
//            System.out.println(ps.addPesel("96030304730"));//WRONG
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        System.out.println(ps.size());
//
//        printPeselNumbers(ps.getPeselNumbers());
    }

    public static void printPeselNumbers(Set<String> peselNumbers) {
        for (String pesel : peselNumbers) {
            System.out.println(pesel);
        }
    }
}
