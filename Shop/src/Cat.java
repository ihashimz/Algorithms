import java.io.Serializable;

public class Cat implements Serializable{

    private int age;
    private double price;

    public Cat(int age, double price) {
        this.age = age;
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public double getPrice() {
        return price;
    }
}
