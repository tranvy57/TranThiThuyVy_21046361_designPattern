import roles.Accountant;
import roles.BaseRole;
import roles.Staff;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Vy", new Staff(new BaseRole()));
        Employee emp2 = new Employee("Tuấn", new Accountant(new BaseRole()));
        emp1.printDuties();
        emp2.printDuties();
    }
}