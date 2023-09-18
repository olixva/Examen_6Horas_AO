package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cliente> listaClientes;

    public Banco() {
        listaClientes = new ArrayList<>();
    }

    public void anadirCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
}
