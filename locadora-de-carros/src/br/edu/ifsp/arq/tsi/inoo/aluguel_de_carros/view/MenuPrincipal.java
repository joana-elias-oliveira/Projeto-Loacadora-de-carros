package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.view;
import java.util.Scanner;

import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller.GerenciadorCarros;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller.GerenciadorClientes;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller.GerenciadorDevolucao;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller.GerenciadorLocacao;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Carro;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Cliente;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Locacao;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.PessoaFisica;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.PessoaJuridica;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorClientes gerenciadorClientes = GerenciadorClientes.getInstancia();
        GerenciadorCarros gerenciadorCarros = GerenciadorCarros.getInstancia();
        GerenciadorLocacao gerenciadorLocacao = new GerenciadorLocacao();
        GerenciadorDevolucao gerenciadorDevolucao = new GerenciadorDevolucao();

        int opcao;
        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Inserir Carro");
            System.out.println("3. Realizar Locação");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Imprimir Lista de Locações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    realizarInsercaoClientes(scanner, gerenciadorClientes);
                    break;
                case 2:
                    realizarInsercaoCarros(scanner, gerenciadorCarros);
                    break;
                case 3:
                    realizarLocacao(scanner, gerenciadorClientes, gerenciadorCarros, gerenciadorLocacao);
                    break;
                case 4:
                    realizarDevolucao(scanner, gerenciadorLocacao, gerenciadorDevolucao);
                    break;
                case 5:
                    imprimirListaLocacoes(gerenciadorLocacao);
                    break;
                case 0:
                    System.out.println("\nSaindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void realizarInsercaoClientes(Scanner scanner, GerenciadorClientes gerenciadorClientes) {
        System.out.println("\n===== Inserção de Clientes =====");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF (ou CNPJ, se for pessoa jurídica): ");
        String documento = scanner.nextLine();

        if (documento.length() == 11) {
            gerenciadorClientes.adicionarCliente(new PessoaFisica(nome, documento));
        } else if (documento.length() == 14) {
            System.out.print("Digite a razão social: ");
            String razaoSocial = scanner.nextLine();
            gerenciadorClientes.adicionarCliente(new PessoaJuridica(nome, documento, razaoSocial));
        } else {
            System.out.println("Formato de documento inválido.");
        }

        System.out.println("Cliente inserido com sucesso!");
    }

    private static void realizarInsercaoCarros(Scanner scanner, GerenciadorCarros gerenciadorCarros) {
        System.out.println("\n===== Inserção de Carros =====");

        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Cquebra de linha

        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();

        System.out.print("Digite a quantidade de portas do carro: ");
        int quantidadePortas = scanner.nextInt();
        scanner.nextLine(); //  quebra de linha

        System.out.print("O carro possui ar-condicionado? (S/N): ");
        boolean arCondicionado = scanner.nextLine().equalsIgnoreCase("S");

        System.out.print("Digite o valor da diária de locação do carro: ");
        double valorDiaria = scanner.nextDouble();

        Carro novoCarro = new Carro(marca, modelo, ano, placa, quantidadePortas, arCondicionado, valorDiaria);
        gerenciadorCarros.adicionarCarro(novoCarro);

        System.out.println("Carro inserido com sucesso!");
    }

    private static void realizarLocacao(Scanner scanner, GerenciadorClientes gerenciadorClientes,
            GerenciadorCarros gerenciadorCarros, GerenciadorLocacao gerenciadorLocacao) {
        System.out.println("\n===== Realização de Locações =====");

        System.out.print("Digite o número de diárias desejadas: ");
        int numeroDiarias = scanner.nextInt();
        scanner.nextLine(); // quebra de linha

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = gerenciadorClientes.buscarClientePorCpf(cpf);

        if (cliente != null) {
            System.out.print("Digite a placa do carro desejado: ");
            String placaCarro = scanner.nextLine();

            Carro carro = gerenciadorCarros.buscarCarroPorPlaca(placaCarro);

            if (carro != null) {
                Locacao locacao = gerenciadorLocacao.realizarLocacao(numeroDiarias, cliente, carro);
                System.out.println("Locação realizada com sucesso!");
                System.out.println("\nID Locação:    " + locacao.getNumero());
                System.out.println("#############################");
            } else {
                System.out.println("Carro não encontrado.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void realizarDevolucao(Scanner scanner, GerenciadorLocacao gerenciadorLocacao,
            GerenciadorDevolucao gerenciadorDevolucao) {
        System.out.println("\n===== Devoluções =====");

        System.out.print("Digite o número da locação a ser devolvida: ");
        int numeroLocacao = scanner.nextInt();
        scanner.nextLine(); //a quebra de linha

        Locacao locacao = null;

        // Buscar a locação pelo número
        for (Locacao l : gerenciadorLocacao.getLocacoes()) {
            if (l.getNumero() == numeroLocacao) {
                locacao = l;
                break;
            }
        }

        if (locacao != null) {
            gerenciadorDevolucao.realizarDevolucao(locacao);
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Locação não encontrada.");
        }
    }

    private static void imprimirListaLocacoes(GerenciadorLocacao gerenciadorLocacao) {
        System.out.println("\n===== Lista de Locações =====");
        for (Locacao locacao : gerenciadorLocacao.getLocacoes()) {
            System.out.println("Código de Locação: " + locacao.getNumero());
            System.out.println("Nome do Cliente: " + locacao.getCliente().getNome());
            System.out.println("Carro Alugado: " + locacao.getCarro().getModelo());
            System.out.println("----------------------------------");
        }
    }
}
