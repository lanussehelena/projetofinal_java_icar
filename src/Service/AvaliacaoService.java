package service;
import model.Avaliacao;
import repository.AvaliacaoRepository;
import java.util.List;


public class AvaliacaoService {

    private AvaliacaoRepository repository = new AvaliacaoRepository();

    public void cadastrar(Avaliacao avaliacao) {
        repository.salvar(avaliacao);
    }

    public List<Avaliacao> listar() {
        return repository.listar();
    }

}
