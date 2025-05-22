package service;

import model.Servico;
import repository.ServicoRepository;

import java.util.List;

public class ServicoService {
    private final ServicoRepository repository = new ServicoRepository();

    public void cadastrarServicoPadrao() {
        List<Servico> lista = List.of(
                criarServico(1, "Lavagem Simples", "Lavagem externa com secagem", 30.0),
                criarServico(2, "Lavagem Completa", "Externa, interna e enceramento", 60.0),
                criarServico(3, "Lavagem Detalhada", "Lavagem detalhada com cera e limpeza de rodas", 80.0),
                criarServico(4, "Lavagem de Motor", "Limpeza cuidadosa do motor com proteção", 50.0),
                criarServico(5, "Vitrificação de Faróis", "Tratamento de transparência para faróis", 90.0),
                criarServico(6, "Higienização Interna Completa", "Aspiração, limpeza de carpetes e forros", 100.0),
                criarServico(7, "Lavagem de Banco", "Limpeza profunda dos bancos com secagem", 75.0),
                criarServico(8, "Lavagem de Chassi", "Limpeza do chassi e proteção contra ferrugem", 110.0)
        );

        for (Servico s : lista) {
            repository.salvar(s);
        }
    }

    private Servico criarServico(int id, String nome, String descricao, double preco) {
        Servico s = new Servico();
        s.id = id;
        s.nome = nome;
        s.descricao = descricao;
        s.preco = preco;
        return s;
    }


    public List<Servico> listar() {
        return repository.listar();
    }

    public Servico buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}