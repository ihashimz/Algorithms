public class Person implements Comparable<Person> {

    private int age;
    private String name;
    private String surname;

    public Person(int age, String surname, String name) {
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person otherPerson) {
        //comparing AGE -> NAME -> SURNAME
        if (this.getAge() > otherPerson.getAge()) {
            return Integer.MAX_VALUE;
        } else if (this.getAge() < otherPerson.getAge()) {
            return Integer.MIN_VALUE;
        } else {
            int comparedNames = this.name.compareTo(otherPerson.getName());
            if (comparedNames == 0) {
                return this.surname.compareTo(otherPerson.getSurname());
            } else if (comparedNames > 0){
               return comparedNames + 10000;
            }
            else {
                return comparedNames - 10000;
            }
        }
    }
}
