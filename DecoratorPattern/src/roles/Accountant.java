package roles;

public class Accountant extends RoleDecorator {
    public Accountant(Role role) {
        super(role);
    }

    public void printDuties() {
        super.printDuties();
        System.out.println("- Tính toán tiền cho công ty.");
        System.out.println("- Nộp tiền vào tài khoản công ty.");
    }
}