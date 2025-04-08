import models.*;

public class Main {
    public static void main(String[] args) {
        // Tạo sản phẩm
        Product coffee = new Product("Cà phê", 30000);
        Product tea = new Product("Trà sữa", 40000);
        Product water = new Product("Nước suối", 15000);

        // Tạo bàn và thêm sản phẩm
        Table table1 = new Table(1);
        table1.addItem(coffee);
        table1.addItem(tea);

        Table table2 = new Table(2);
        table2.addItem(coffee);
        table2.addItem(water);
        table2.addItem(tea);

        // Tạo quán cà phê và thêm bàn
        CoffeeShop shop = new CoffeeShop("Vy's Coffee");
        shop.addTable(table1);
        shop.addTable(table2);

        // In thông tin
        System.out.println(table1);
        System.out.println(table2);
        System.out.println(shop);
    }
}