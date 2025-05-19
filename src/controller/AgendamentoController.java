package controller;

import model.Cliente;
import model.Servico;
import service.AgendamentoService;
import model.Agendamento;
import model.FormaPagamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AgendamentoController {
    private AgendamentoService service = new AgendamentoService();
    private ServicoController servicoController;
    private Scanner scanner = new Scanner(System.in);

    public AgendamentoController(ServicoController servicoController) {
        this.servicoController = servicoController;
    }

    public void agendarMultiplosServicos(Cliente cliente) {
        servicoController.listarServicos();

        System.out.print("Quantos serviços deseja agendar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        List<Servico> servicosSelecionados = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o ID do serviço " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Servico servico = servicoController.buscarPorId(id);
            if (servico != null) {
                servicosSelecionados.add(servico);
            } else {
                System.out.println("Serviço com ID " + id + " não encontrado.");
            }
        }