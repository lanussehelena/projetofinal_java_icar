import controller.AvaliacaoController;
import controller.ClienteController;
import controller.ServicoController;
import controller.AgendamentoController;
import model.Cliente;
import model.Servico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        ServicoController servicoController = new ServicoController();
        AgendamentoController agendamentoController = new AgendamentoController(servicoController); // ✅ Corrigido
        AvaliacaoController avaliacaoController = new AvaliacaoController();

        servicoController.cadastrarServicosIniciais();

        int opcao;
        Cliente clienteLogado = null;

        do {
            System.out.println("\n=== iCAR - Sistema de Agendamento ===");
            if (clienteLogado == null) {
                System.out.println("1 - Cadastrar cliente");
                System.out.println("2 - Login");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> clienteController.cadastrarCliente();
                    case 2 -> clienteLogado = clienteController.fazerLogin();
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("1 - Listar serviços");
                System.out.println("2 - Agendar serviço");
                System.out.println("3 - Ver agendamentos");
                System.out.println("4 - Avaliar serviço");
                System.out.println("5 - Ver avaliações");
                System.out.println("6 - Logout");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> servicoController.listarServicos();
                    case 2 -> agendamentoController.agendarMultiplosServicos(clienteLogado); // ✅ agora limpo!
                    case 3 -> agendamentoController.listarAgendamentosDoCliente(clienteLogado); // ✅ opcional e útil
                    case 4 -> {
                        System.out.print("Digite o ID do serviço que deseja avaliar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Servico servico = servicoController.buscarPorId(id);
                        if (servico != null) {
                            avaliacaoController.avaliarServico(clienteLogado, servico);
                        } else {
                            System.out.println("Serviço não encontrado.");
                        }
                    }
                    case 5 -> avaliacaoController.listarAvaliacoes();
                    case 6 -> {
                        clienteLogado = null;
                        System.out.println("Logout realizado.");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }

        } while (opcao != 0);
    }
}
