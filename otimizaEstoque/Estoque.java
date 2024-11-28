package otimizaEstoque;

import java.util.List;

class Estoque {
    private final double capacity;
    private final List<Item> items;

    public Estoque(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }
}
