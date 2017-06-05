import java.io.Serializable;
import java.util.*;

public class Store implements Serializable{

    private IOService IOs = new IOService("/home/mateusz/Desktop/Algorithms/Shop/store.dat");

    private Map<String, Employee> employeeMap;

    private Set<Cat> cats;
    private Set<Lizard> lizards;

    private double managersIncome;
    private double normalEmployeeIncome;

    public Store() {
        employeeMap = new HashMap<>();
        cats = new HashSet<>();
        lizards = new HashSet<>();
    }

    public boolean addEmployee(String surname, boolean isManager) {

        Employee temp = employeeMap.getOrDefault(surname, null);

        if (temp == null) {
            employeeMap.put(surname, new Employee(surname, isManager));
            return true;
        }
        return false;
    }

    public void addLizard(double price) {
        lizards.add(new Lizard(price));
    }

    public void addCat(int age, double price) {
        cats.add(new Cat(age, price));
    }

    public Cat sellCat(String employeeSurname) {
        Employee employee = getEmployee(employeeSurname);
        if (!cats.isEmpty() && employee != null) {
            //Getting youngest
            Cat tempCat = cats
                    .stream()
                    .reduce((c1, c2) -> c1.getAge() < c2.getAge() ? c1 : c2)
                    .get();

            cats.remove(tempCat);
            employee.incrementSalary(tempCat.getPrice() * 0.02);

            if (employee.isManager()) {
                managersIncome += tempCat.getPrice();
            } else {
                normalEmployeeIncome += tempCat.getPrice();
            }

            return tempCat;
        }
        return null;
    }

    public Lizard sellLizard(String employeeSurname) {
        Employee employee = getEmployee(employeeSurname);
        if (!lizards.isEmpty() && employee != null) {
            //Getting most expensive one
            Lizard tempLizard = lizards
                    .stream()
                    .reduce((l1, l2) -> l1.getPrice() > l2.getPrice() ? l1 : l2)
                    .get();
            lizards.remove(tempLizard);
            employee.incrementSalary(tempLizard.getPrice() * 0.02);

            if (employee.isManager()) {
                managersIncome += tempLizard.getPrice();
            } else {
                normalEmployeeIncome += tempLizard.getPrice();
            }

            return tempLizard;
        }
        return null;
    }

    public Map<String, Employee> getEmployeeList() {
        return Collections.unmodifiableMap(employeeMap);
    }

    public Set<Cat> getCats() {
        return Collections.unmodifiableSet(cats);
    }

    public Set<Lizard> getLizards() {
        return Collections.unmodifiableSet(lizards);
    }

    public void dailyFinalize() {
        employeeMap.values()
                .stream()
                .filter(Employee::isManager)
                .forEach(e -> e.incrementSalary(normalEmployeeIncome * 0.05));
        IOs.saveStoreToFile(this);
    }

    private Employee getEmployee(String surname) {
        return employeeMap.getOrDefault(surname, null);
    }

    public double getManagersIncome() {
        return managersIncome;
    }

    public double getNormalEmployeeIncome() {
        return normalEmployeeIncome;
    }
}
