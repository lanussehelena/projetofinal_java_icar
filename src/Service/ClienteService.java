package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public void cadastrar(Cliente cliente) {
        repository.salvar(cliente);
    }

    public List<Cliente> listar() {
        return repository.listar();
    }

    public Cliente buscarPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }

    public Cliente login(String email, String senha) {
        Cliente cliente = repository.buscarPorEmail(email);
        if (cliente != null && cliente.senha.equals(senha)) {
            return cliente;
        }
        return null;
    }

}