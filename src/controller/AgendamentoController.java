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
        System.out.print("Data do agendamento (formato dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInformada;
        try {
            dataInformada = sdf.parse(dataStr);
            Date hoje = new Date();
            if (dataInformada.before(hoje)) {
                System.out.println("Data inválida. Não pode ser anterior à hoje.");
                return;
            }
        } catch (ParseException e) {
            System.out.println("Formato de data inválido.");
            return;
        }

        System.out.print("Horário do agendamento: ");
        String horario = scanner.nextLine();

        System.out.println("Forma de pagamento:\n1 - Espécie\n2 - Pix\n3 - Crédito\n4 - Débito");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        FormaPagamento formaPagamento = FormaPagamento.DEBITO; // default
        int parcelas = 1;
        double valorRecebido = 0;

        switch (opcao) {
            case 1 -> {
                formaPagamento = FormaPagamento.ESPECIE;
                System.out.print("Valor recebido em dinheiro: ");
                valorRecebido = scanner.nextDouble();
                scanner.nextLine();
            }
            case 2 -> formaPagamento = FormaPagamento.PIX;
            case 3 -> {
                formaPagamento = FormaPagamento.CREDITO;
                System.out.print("Número de parcelas: ");
                parcelas = scanner.nextInt();
                scanner.nextLine();
            }
            case 4 -> formaPagamento = FormaPagamento.DEBITO;
            default -> System.out.println("Opção inválida. Será usado Débito.");
        }

        for (Servico servicoSelecionado : servicosSelecionados) {
            Agendamento agendamento = new Agendamento();
            agendamento.cliente = cliente;
            agendamento.servico = servicoSelecionado;
            agendamento.data = dataInformada;
            agendamento.horario = horario;
            agendamento.formaPagamento = formaPagamento;
            agendamento.parcelas = parcelas;
            agendamento.valorRecebido = valorRecebido;

            service.agendar(agendamento);
            System.out.println("✅ Serviço \"" + servicoSelecionado.nome + "\" agendado com sucesso.");
        }
    }
}



