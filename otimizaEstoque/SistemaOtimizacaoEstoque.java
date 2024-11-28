package otimizaEstoque;

import java.util.ArrayList;

public class SistemaOtimizacaoEstoque {
    public static void main(String[] args) {
        ArrayList<Object> produtos = new ArrayList<>();
        produtos.add(new Item(10, 60));
        produtos.add(new Item(20, 100));
        produtos.add(new Item(30, 120));

        double capacidadeEstoque = 50;

        Estoque estoque = new Estoque(capacidadeEstoque, produtos);

        OtimizadorEstoque solver = new OtimizadorEstoque();
        EstadoEstoque melhorEstado = solver.solve(estoque);

        System.out.println("Itens selecionados para o estoque:");
        for (Item item : melhorEstado.getSelectedItems()) {
            System.out.println("Peso: " + item.getWeight() + ", Valor: " + item.getValue());
        }
        System.out.println("Peso total utilizado: " + melhorEstado.getTotalWeight());
        System.out.println("Valor total armazenado: " + melhorEstado.getTotalValue());
    }
}
