import controller.ClienteController;
import model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();


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