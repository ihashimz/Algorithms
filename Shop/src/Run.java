import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        Store newStore;

        try {
            newStore = IOService.readStoreFromFile("/home/mateusz/Desktop/Algorithms/Shop/store.dat");
            System.out.println("Opened previous session...");

            System.out.println("EMPLOYEES");
            newStore.getEmployeeList().values().stream()
                    .sorted(Comparator.comparing(Employee::getSurname))
                    .forEach(e -> System.out.println(e.getSurname() + " - " +  e.getSalary() + " - " + e.isManager()));

            System.out.println("CATS");
            newStore.getCats().forEach(c -> System.out.println("Age " + c.getAge() + ", Price " + c.getPrice()));

            System.out.println("LIZARDS");
            newStore.getLizards().forEach(c -> System.out.println("Price " + c.getPrice()));
            System.out.println();


        }catch (IOException | ClassNotFoundException e){
            System.out.println("Couldn't load last session, opened new one." );
            newStore = openNewShop();
        }

        runSalesManager(newStore);
        endDayRapport(newStore);
    }

    public static Store openNewShop() {

        Scanner sc = new Scanner(System.in);
        int amount = 0;
        Store store = new Store();

        System.out.println("ENTER AMOUNT OF MANAGERS : ");
        amount = sc.nextInt();
        while ((amount--) != 0) {
            System.out.println("ENTER SURNAME : ");
            store.addEmployee(sc.next(), true);
        }
        System.out.println("ENTER AMOUNT OF NORMAL EMPLOYEES : ");
        amount = sc.nextInt();
        while ((amount--) != 0) {
            System.out.println("ENTER SURNAME : ");
            store.addEmployee(sc.next(), false);
        }
        System.out.println("ENTER AMOUNT OF CATS : ");
        amount = sc.nextInt();
        while ((amount--) != 0) {
            System.out.println("ENTER AGE & PRICE : ");
            store.addCat(sc.nextInt(), sc.nextDouble());
        }
        System.out.println("ENTER AMOUNT OF LIZARDS : ");
        amount = sc.nextInt();
        while ((amount--) != 0) {
            System.out.println("ENTER PRICE : ");
            store.addLizard(sc.nextDouble());
        }
        return store;
    }

    public static void runSalesManager(Store store){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("--------------------------------------");
            System.out.println("ENTER E TO REGISTER SALE || Q TO QUIT");
            System.out.println("--------------------------------------");
            String input = sc.next();
            if(input.contains("Q")){
                store.dailyFinalize();
                exit = true;
            }
            else if(input.contains("E")){
                String seller;
                String answer;
                System.out.println("ENTER SELLER SURNAME AND C -> CAT || L -> LIZARD");
                seller = sc.next();
                answer = sc.next();
                if(answer.contains("C")){
                    Cat tempCat = store.sellCat(seller);
                    if(tempCat!= null) {
                        System.out.println("\nEmployee " + seller + " sold "
                                + tempCat.getAge() + " YO cat for " + tempCat.getPrice() + "\n");
                    }else {
                        System.out.println("Employee or animal not found");
                    }
                }
                else if(answer.contains("L")){
                    Lizard tempLizard = store.sellLizard(seller);
                    if(tempLizard!= null) {
                        System.out.println("\nEmployee " + seller + " sold lizard for " + tempLizard.getPrice() + "\n");
                    }else {
                        System.out.println("Employee or animal not found");
                    }
                }
                else {
                    System.out.println("Something went wrong?");
                }
            }else {
                System.out.println("Wrong input.");
            }
        }
    }

    public static void endDayRapport(Store store){

        System.out.println("----------------------");
        System.out.println("FULL STORE INCOME WAS : " + (store.getManagersIncome() + store.getNormalEmployeeIncome()));
        System.out.println("MANAGERS -> " + store.getManagersIncome());
        System.out.println("NORMAL EMPLOYEE -> " + store.getNormalEmployeeIncome());

        store.getEmployeeList().values().stream()
                .sorted(Comparator.comparing(Employee::getSurname))
                .forEach(c -> System.out.println(c.getSurname() + " " + c.getSalary()));

    }
}
