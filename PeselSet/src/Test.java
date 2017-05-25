import java.util.Set;

public class Test {

    public static void main(String[] args) {

        PeselSet ps= new PeselSet();

        try {
            System.out.println(ps.addPesel("96030804730"));
            System.out.println(ps.addPesel("96030804730"));//DUPLICATE
            System.out.println(ps.addPesel("96030304730"));//WRONG
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(ps.size());

        printPeselNumbers(ps.getPeselNumbers());
    }

    public static void printPeselNumbers(Set<String> peselNumbers){
        for(String pesel: peselNumbers){
            System.out.println(pesel);
        }
    }
}
