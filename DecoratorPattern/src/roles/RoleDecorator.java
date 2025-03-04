package roles;

class RoleDecorator implements Role {
    protected Role role;

    public RoleDecorator(Role role) {
        this.role = role;
    }

    public void printDuties() {
        role.printDuties();
    }
}