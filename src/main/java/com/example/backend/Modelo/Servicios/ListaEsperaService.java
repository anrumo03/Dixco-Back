package com.example.backend.Modelo.Servicios;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.ListaEspera;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Enumeraciones.EstadoLista;
import com.example.backend.Modelo.Enumeraciones.EstadoReserva;
import com.example.backend.Modelo.Repositorios.ClienteRepo;
import com.example.backend.Modelo.Repositorios.ListaEsperaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class ListaEsperaService {

    @Autowired
    private ListaEsperaRepo listaEsperaRepo;
    @Autowired
    private ClienteRepo clienteRepo;

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
        // Buscar la lista de espera y el cliente en la base de datos
        Optional<ListaEspera> listaEsperaOptional = listaEsperaRepo.findById(idListaEspera);
        Optional<Cliente> clienteOptional = clienteRepo.findById(idCliente);

        // Verificar si la lista de espera y el cliente existen
        if (listaEsperaOptional.isPresent() && clienteOptional.isPresent()) {
            ListaEspera listaEspera = listaEsperaOptional.get();
            Cliente cliente = clienteOptional.get();

            // Obtener el conjunto actual de listas de espera del cliente
            Set<ListaEspera> listasEsperaCliente = cliente.getListaEspera();

            // Agregar la nueva lista de espera al conjunto
            listasEsperaCliente.add(listaEspera);

            // Actualizar el conjunto en el cliente
            cliente.setListaEspera(listasEsperaCliente);

            // Guardar el cliente actualizado en la base de datos
            clienteRepo.save(cliente);
        } else {
            // Manejar el caso en el que la lista de espera o el cliente no existen
            // Por ejemplo, lanzar una excepción o manejar el error de otra manera
        }
    }



}



