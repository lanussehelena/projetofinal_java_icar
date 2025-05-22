package controller;

import model.Servico;
import service.ServicoService;

import java.util.List;

public class ServicoController {
    private static ServicoService service = new ServicoService();

    public void cadastrarServicosIniciais() {
        service.cadastrarServicoPadrao();
    }

    public static void listarServicos() {
        List<Servico> servicos = service.listar();
        System.out.println("\n=== Serviços Disponíveis ===");
        for (Servico s : servicos) {
            s.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }

    public static Servico buscarPorId(int id) {
        return service.buscarPorId(id);
    }
}
