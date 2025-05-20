package model;

public class Avaliacao {
    public Cliente cliente;
    public Servico servico;
    public int nota; // de 1 a 5
    public String comentario;

    public void exibir() {
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Serviço: " + servico.nome);
        System.out.println("Nota: " + nota);
        System.out.println("Comentário: " + comentario);
    }
}
