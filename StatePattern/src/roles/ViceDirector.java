package roles;

public class ViceDirector implements Role{

    @Override
    public void printDuties() {
        System.out.println("Phụ trách khi giám đốc đi vắng");
    }
}
