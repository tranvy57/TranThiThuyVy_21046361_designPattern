package models;

public class Table extends CompositeItem {
    private int tableNumber;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " - Total: " + getPrice() + " VND";
    }
}

