import roles.Accountant;
import roles.Staff;
import roles.ViceDirector;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Vy", new Staff());
        Employee emp2 = new Employee("Tuấn", new Accountant());
        emp1.printDuties();
        emp2.printDuties();

        // Chuyển đổi vai trò
        emp1.changeRole(new ViceDirector());
        System.out.println("\nSau khi thăng chức:");
        emp1.printDuties();
    }
}