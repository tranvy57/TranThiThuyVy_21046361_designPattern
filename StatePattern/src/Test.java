import roles.Accountant;
import roles.Staff;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Vy", new Staff());
        Employee emp2 = new Employee("Tuấn", new Accountant());
        emp1.printDuties();
        emp2.printDuties();
    }
}
