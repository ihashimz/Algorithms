import java.util.Set;

public class Test {

    public static void main(String[] args) {

        PeselSet ps= new PeselSet();

        ps.addPesel("96030804730");
        ps.addPesel("96030804730");

        ps.addPesel("44051401358");
        ps.addPesel("96032134730");//wrong

        System.out.println(ps.getPeselNumbers().size());

        printPeselNumbers(ps.getPeselNumbers());

    }

    public static void printPeselNumbers(Set<String> peselNumbers){
        for(String pesel: peselNumbers){
            System.out.println(pesel);
        }
    }
}
