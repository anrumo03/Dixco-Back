package services;

import com.example.backend.Modelo.Entidades.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteIn {
    Cliente crearCliente (Cliente cliente) throws Exception;
    Cliente actualizarCliente (Cliente cliente) throws Exception;
    Cliente getClienteById (String idCliente) throws Exception;
    List<Cliente> listarClientes();

}
