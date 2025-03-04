package roles;

public class Staff extends RoleDecorator {
    public Staff(Role role) {
        super(role);
    }

    public void printDuties() {
        super.printDuties();
        System.out.println("- Pha trà.");
        System.out.println("- Giữ xe.");
    }
}