package models;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeItem implements BillComponent {
    protected List<BillComponent> items = new ArrayList<>();

    public void addItem(BillComponent item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        return items.stream().mapToDouble(BillComponent::getPrice).sum();
    }
}
