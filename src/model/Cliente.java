package model;

public class Cliente {
    public String nome;
    public String email;
    public String senha;
    public String modeloVeiculo;
    public String placa;

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Veículo: " + modeloVeiculo + " - Placa: " + placa);
    }
}