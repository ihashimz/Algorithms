public class Person implements Comparable<Person> {

    private int age;
    private String surname;

    public Person(int age, String surname) {
        this.age = age;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public int compareTo(Person otherPerson) {
        if (this.getAge() > otherPerson.getAge()) {
            return 1;
        } else if (this.getAge() < otherPerson.getAge()) {
            return -1;
        } else {
            return this.getSurname().compareTo(otherPerson.getSurname());
        }
    }
}
