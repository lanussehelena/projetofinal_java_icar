package controller;

import model.Avaliacao;
import model.Cliente;
import model.Servico;
import service.AvaliacaoService;

import java.util.Scanner;

public class AvaliacaoController {
    private AvaliacaoService service = new AvaliacaoService();
    private Scanner scanner = new Scanner(System.in);

    public void avaliarServico(Cliente cliente, Servico servico) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.cliente = cliente;
        avaliacao.servico = servico;

        System.out.print("Dê uma nota de 1 a 5 para o serviço: ");
        avaliacao.nota = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Comentário: ");
        avaliacao.comentario = scanner.nextLine();

        service.cadastrar(avaliacao);
        System.out.println("Avaliação registrada com sucesso!");
    }

    public void listarAvaliacoes() {
        for (Avaliacao a : service.listar()) {
            a.exibir();
            System.out.println("----------------------");
        }
    }
}