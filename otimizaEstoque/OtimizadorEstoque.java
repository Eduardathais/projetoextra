package otimizaEstoque;

import java.util.PriorityQueue;

class OtimizadorEstoque {
    private static final int MAX_QUEUE_SIZE = 1000;
    private static final int MAX_DEPTH = 50;

    public EstadoEstoque solve(Estoque estoque) {
        PriorityQueue<EstadoEstoque> queue = new PriorityQueue<>(
                (a, b) -> Double.compare(calculatePriority(b), calculatePriority(a))
        );

        EstadoEstoque initialState = new EstadoEstoque();
        queue.add(initialState);

        EstadoEstoque bestState = initialState;

        while (!queue.isEmpty() && queue.size() <= MAX_QUEUE_SIZE) {
            EstadoEstoque currentState = queue.poll();

            if (currentState.getTotalValue() > bestState.getTotalValue()) {
                bestState = currentState;
            }

            for (Item item : estoque.getItems()) {
                if (!currentState.getSelectedItems().contains(item)) {
                    EstadoEstoque newState = new EstadoEstoque(currentState.getSelectedItems());
                    newState.addItem(item);

                    if (newState.getTotalWeight() <= estoque.getCapacity()) {
                        queue.add(newState);
                    }
                }
            }
        }

        return bestState;
    }
    private double calculatePriority(EstadoEstoque state) {
        return state.getTotalValue() / (state.getTotalWeight() + 1);
    }
}
