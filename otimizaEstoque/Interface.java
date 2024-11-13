package otimizaEstoque;

import java.util.List;
import java.util.Scanner;

public class Interface {
    private Estoque estoque;
    private KnapsackOptimization otimizador;
    private Scanner scanner;

    public Interface() {
        this.otimizador = new KnapsackOptimization();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Defina a capacidade do estoque: ");
        int capacidade = scanner.nextInt();
        estoque = new Estoque(capacidade);

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Cadastrar otimizaEstoque.Produto");
            System.out.println("2. Executar Otimização");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    executarOtimizacao();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private void cadastrarProduto() {
        scanner.nextLine();
        System.out.print("Nome do otimizaEstoque.Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Valor do otimizaEstoque.Produto: ");
        int valor = scanner.nextInt();
        System.out.print("Peso do otimizaEstoque.Produto: ");
        int peso = scanner.nextInt();

        Produto produto = new Produto(nome, valor, peso);
        estoque.adicionarProduto(produto);
        System.out.println("otimizaEstoque.Produto cadastrado: " + produto);
    }

    private void executarOtimizacao() {
        List<Produto> produtosSelecionados = otimizador.otimizarEspacoEstoque(estoque.getProdutos(), estoque.getCapacidade());
        System.out.println("Produtos selecionados para otimização:");
        for (Produto produto : produtosSelecionados) {
            System.out.println(produto);
        }
    }
}
