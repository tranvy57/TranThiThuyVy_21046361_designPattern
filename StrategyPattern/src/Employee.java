import roles.Role;

class Employee {
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void printDuties() {
        System.out.println(name + " có nhiệm vụ:");
        role.printDuties();
    }

    public void changeRole(Role newRole) {
        this.role = newRole;
    }
}
