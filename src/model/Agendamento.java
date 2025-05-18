package model;

import java.util.Date;
import java.text.SimpleDateFormat;



public class Agendamento {
    public Cliente cliente;
    public Servico servico;
    public Date data;
    public String horario;
    public FormaPagamento formaPagamento;
    public int parcelas; // se for crédito
    public double valorRecebido; // se for espécie

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void exibirInformacoes() {
        System.out.println("Cliente: " + cliente.nome + " (" + cliente.placa + ")");
        System.out.println("Serviço: " + servico.nome);

        System.out.println("Data: " + sdf.format(data) + " | Horário: " + horario);
        System.out.println("Pagamento: " + formaPagamento);

        if (formaPagamento == FormaPagamento.CREDITO && parcelas > 1) {
            System.out.printf("Parcelado em %d vezes de R$ %.2f\n", parcelas, servico.preco / parcelas);
        }

        if (formaPagamento == FormaPagamento.ESPECIE && valorRecebido > servico.preco) {
            double troco = valorRecebido - servico.preco;
            System.out.printf("Valor recebido: R$ %.2f | Troco: R$ %.2f\n", valorRecebido, troco);
        }
    }
}
