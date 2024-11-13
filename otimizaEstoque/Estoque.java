package otimizaEstoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int capacidade;
    private List<Produto> produtos;

    public Estoque(int capacidade) {
        this.capacidade = capacidade;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
