package models;

public class CoffeeShop extends CompositeItem {
    private String name;

    public CoffeeShop(String name) {
        this.name = name;
    }

    public void addTable(Table table) {
        addItem(table);
    }

    @Override
    public String toString() {
        return "CoffeeShop: " + name + " - Revenue: " + getPrice() + " VND";
    }
}
