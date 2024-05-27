package com.example.backend.Modelo.Servicios;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.ClienteListaEspera;
import com.example.backend.Modelo.Entidades.ListaEspera;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Enumeraciones.EstadoLista;
import com.example.backend.Modelo.Enumeraciones.EstadoReserva;
import com.example.backend.Modelo.Repositorios.ClienteListaRepo;
import com.example.backend.Modelo.Repositorios.ClienteRepo;
import com.example.backend.Modelo.Repositorios.ListaEsperaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ListaEsperaService {

    @Autowired
    private ListaEsperaRepo listaEsperaRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private ClienteListaRepo clienteListaEsperaRepo;


    public ListaEspera crearLista(ListaEspera lista) {

        lista.setEstado(EstadoLista.PENDIENTE);
        // Guarda la reserva en la base de datos
        ListaEspera nuevaLista = listaEsperaRepo.save(lista);

        // Actualiza el estado de la reserva a "CONFIRMADA" después de guardarla en la base de datos
        nuevaLista.setEstado(EstadoLista.PENDIENTE);
        listaEsperaRepo.save(nuevaLista); // Guarda la reserva actualizada en la base de datos

        return nuevaLista;
    }

    public void asociarListaEsperaACliente(Long idListaEspera, Long idCliente) {
        Optional<ListaEspera> listaEsperaOptional = listaEsperaRepo.findById(idListaEspera);
        Optional<Cliente> clienteOptional = clienteRepo.findById(idCliente);

        if (listaEsperaOptional.isPresent() && clienteOptional.isPresent()) {
            ListaEspera listaEspera = listaEsperaOptional.get();
            Cliente cliente = clienteOptional.get();

            // Crear un nuevo objeto ClienteListaEspera
            ClienteListaEspera clienteListaEspera = new ClienteListaEspera();
            clienteListaEspera.setCliente(cliente);
            clienteListaEspera.setListaEspera(listaEspera);

            // Persistir la asociación en la base de datos
            clienteListaEsperaRepo.save(clienteListaEspera);
        } else {
            // Manejar el caso en el que la lista de espera o el cliente no existen
        }
    }

    public List<ListaEspera> obtenerListasEsperaPorEmail(String email) {
        // Buscar al cliente por su correo electrónico
        Optional<Cliente> clienteOptional = clienteRepo.findOptionalClienteByEmail(email);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            // Obtener las listas de espera asociadas a través de la tabla intermedia
            List<ListaEspera> listasEspera = new ArrayList<>();
            for (ClienteListaEspera clienteListaEspera : clienteListaEsperaRepo.findByCliente(cliente)) {
                listasEspera.add(clienteListaEspera.getListaEspera());
            }
            return listasEspera;
        } else {
            // Manejar el caso en el que el cliente no existe
            return List.of();
        }
    }


}



