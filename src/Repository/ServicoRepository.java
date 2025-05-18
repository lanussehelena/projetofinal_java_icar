package Repository;

import model.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {
    private List<Servico> servicos = new ArrayList<>();

    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    public List<Servico> listar() {
        return servicos;
    }

    public Servico buscarPorId(int id) {
        for (Servico s : servicos) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
}