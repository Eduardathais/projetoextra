package otimizaEstoque;

import java.util.ArrayList;
import java.util.List;

class EstadoEstoque {
    protected List<Item> selectedItems;
    protected double totalWeight;
    protected double totalValue;

    public EstadoEstoque() {
        this.selectedItems = new ArrayList<>();
        this.totalWeight = 0;
        this.totalValue = 0;
    }

    public EstadoEstoque(List<Item> selectedItems) {
        this.selectedItems = new ArrayList<>(selectedItems);
        this.totalWeight = selectedItems.stream().mapToDouble(Item::getWeight).sum();
        this.totalValue = selectedItems.stream().mapToDouble(Item::getValue).sum();
    }

    public void addItem(Item item) {
        selectedItems.add(item);
        totalWeight += item.getWeight();
        totalValue += item.getValue();
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public double heuristic(double capacity) {
        return totalValue + (capacity - totalWeight);
    }
}
