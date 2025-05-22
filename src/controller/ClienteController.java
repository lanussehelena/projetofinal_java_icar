package controller;

import model.Cliente;
import service.ClienteService;

import java.util.Scanner;
import java.util.List;

public class ClienteController {
    private ClienteService service = new ClienteService();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.print("Nome: ");
        cliente.nome = scanner.nextLine();

        System.out.print("E-mail: ");
        cliente.email = scanner.nextLine();

        System.out.print("Senha: ");
        cliente.senha = scanner.nextLine();

        System.out.print("Modelo do veículo: ");
        cliente.modeloVeiculo = scanner.nextLine();

        System.out.print("Placa: ");
        cliente.placa = scanner.nextLine();

        service.cadastrar(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        List<Cliente> clientes = service.listar();
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente c : clientes) {
            c.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }

    public Cliente buscarPorEmail() {
        System.out.print("Digite o e-mail do cliente: ");
        String email = scanner.nextLine();
        Cliente c = service.buscarPorEmail(email);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
        }
        return c;
    }

    public Cliente fazerLogin() {
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente logado = service.login(email, senha);
        if (logado != null) {
            System.out.println("Login realizado com sucesso! Bem-vindo(a), " + logado.nome);
            return logado;
        } else {
            System.out.println("E-mail ou senha incorretos.");
            return null;
        }
    }

}
