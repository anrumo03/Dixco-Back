package services;

import com.example.backend.Modelo.Entidades.Cliente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.ClienteRepo;
import services.excepciones.Excepcion;

import javax.print.AttributeException;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService implements ClienteIn {
    private final ClienteRepo clienteRepo;

    @Override
    public Cliente crearCliente(Cliente cliente) throws Exception {
        try{

            return clienteRepo.save(cliente);
        }
        catch (Exception e) {
            System.out.println("No se ha podido registrar el cliente en la base de datos");
            return null;
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        if (clienteRepo.findById(cliente.getIdCliente()).isPresent()) {
            return clienteRepo.save(cliente);
        } else {
            throw new Excepcion("El paciente no existe en la base de datos");
        }
    }

    @Override
    public Cliente getClienteById(String idCliente) throws Exception {
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return null;
    }
}
