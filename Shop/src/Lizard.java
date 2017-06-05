import java.io.Serializable;

public class Lizard implements Serializable {

    private double price;

    public Lizard(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
