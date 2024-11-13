package otimizaEstoque;

import java.util.ArrayList;
import java.util.List;
public class KnapsackOptimization {
    public List<Produto> otimizarEspacoEstoque(List<Produto> produtos, int capacidadeEstoque) {
        int n = produtos.size();
        int[][] dp = new int[n + 1][capacidadeEstoque + 1];

        for (int i = 1; i <= n; i++) {
            Produto produto = produtos.get(i - 1);
            for (int j = 1; j <= capacidadeEstoque; j++) {
                if (produto.getPeso() <= j) {
                    dp[i][j] = Math.max(produto.getValor() + dp[i - 1][j - produto.getPeso()], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<Produto> produtosSelecionados = new ArrayList<>();
        int res = dp[n][capacidadeEstoque];
        int w = capacidadeEstoque;

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                Produto produto = produtos.get(i - 1);
                produtosSelecionados.add(produto);
                res -= produto.getValor();
                w -= produto.getPeso();
            }
        }
        return produtosSelecionados;
    }
}
