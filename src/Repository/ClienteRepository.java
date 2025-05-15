package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente buscarPorEmail(String email) {
        for (Cliente c : clientes) {
            if (c.email.equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }
}