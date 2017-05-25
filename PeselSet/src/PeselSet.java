import java.util.HashSet;
import java.util.Set;

public class PeselSet {

    MySet<Pesel> peselSet = new MySet<>();

    public Set<String> getPeselNumbers(){
        Set<String> temp = new HashSet<>();
        for(Pesel pesel : this.peselSet.getSet()){
            temp.add(pesel.getNumber());
        }
        return temp;
    }

    public int test(){
        return peselSet.size();
    }

    public boolean addPesel(String pesel){
        Pesel temp = new Pesel(pesel);
        if(checkIfCorrect(temp)){
            peselSet.add(temp);
            return true;
        }
        return false;
    }

    private boolean checkIfCorrect(Pesel pesel) {

        if(pesel.getNumber().length() != 11) return false;

        char[] peselArray = pesel.getNumber().toCharArray();
        int[] converted = new int[11];
        for (int i = 0; i < converted.length; i++) {
            converted[i] = Character.getNumericValue(peselArray[i]);
        }
        int controlSum = 9 * converted[0] + 7 * converted[1] + 3 * converted[2] +
                converted[3] + 9 * converted[4] + 7 * converted[5] + 3 * converted[6] +
                converted[7] + 9 * converted[8] + 7 * converted[9];

        return controlSum % 10 == converted[10];
    }

    public class Pesel {
        String number;

        public Pesel(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if(o instanceof Pesel){
                return this.number.equals(((Pesel) o).getNumber());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.number.hashCode() + 1;
        }
    }
}
