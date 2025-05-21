package repository;

import model.Avaliacao;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void salvar(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> listar() {
        return avaliacoes;
    }
}