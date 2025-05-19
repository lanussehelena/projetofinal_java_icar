package service;

import model.Agendamento;
import repository.AgendamentoRepository;

import java.util.List;

public class AgendamentoService {
    private AgendamentoRepository repository = new AgendamentoRepository();

    public void agendar(Agendamento agendamento) {
        repository.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return repository.listar();
    }
}