package model;

public class Servico {
    public int id;
    public String nome;
    public String descricao;
    public double preco;

    public void exibirInformacoes() {
        System.out.println(id + " - " + nome + " | R$ " + preco);
        System.out.println("Descrição: " + descricao);
    }
}
