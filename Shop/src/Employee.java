import java.io.Serializable;

public class Employee implements Serializable {

    private String surname;
    private boolean isManager;
    private double salary;

    public Employee(String surname, boolean isManager) {
        this.surname = surname;
        this.isManager = isManager;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isManager() {
        return isManager;
    }

    public double getSalary() {
        return salary;
    }

    public void incrementSalary(double salary) {
        this.salary += salary;
    }

}
