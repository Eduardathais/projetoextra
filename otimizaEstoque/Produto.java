package otimizaEstoque;

public class Produto {
    private int valor;
    private int peso;
    private String nome;

    public Produto(String nome, int valor, int peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "otimizaEstoque.Produto: " + nome + " | Valor: " + valor + " | Peso: " + peso;
    }
}