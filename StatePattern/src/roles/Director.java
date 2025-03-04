package roles;

public class Director implements Role{

    @Override
    public void printDuties() {
        System.out.println("Ra quyết định quản lý công ty");
    }
}
