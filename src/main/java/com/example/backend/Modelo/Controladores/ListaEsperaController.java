package com.example.backend.Modelo.Controladores;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.ClienteListaEspera;
import com.example.backend.Modelo.Entidades.ListaEspera;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Repositorios.ClienteListaRepo;
import com.example.backend.Modelo.Repositorios.ClienteRepo;
import com.example.backend.Modelo.Repositorios.ListaEsperaRepo;
import com.example.backend.Modelo.Repositorios.ReservaRepo;
import com.example.backend.Modelo.Servicios.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lista-espera")
public class ListaEsperaController {

    private final ListaEsperaService listaEsperaService;


    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private ClienteListaRepo clienteListaRepo;

    @Autowired
    public ListaEsperaController(ListaEsperaService listaEsperaService) {
        this.listaEsperaService = listaEsperaService;
    }

    @PostMapping("/apuntarse")
    public ResponseEntity<ListaEspera> apuntarseListaEspera(@RequestBody ListaEspera listaEspera ) {

        // Llama al servicio para crear la lista de espera
        ListaEspera nuevaLista = listaEsperaService.crearLista(listaEspera);
        return new ResponseEntity<>(nuevaLista, HttpStatus.CREATED);
    }

    @PostMapping("/asociar-cliente/{idListaEspera}/{idCliente}")
    public ResponseEntity<String> asociarListaEsperaACliente(@PathVariable Long idListaEspera, @PathVariable Long idCliente) {
        listaEsperaService.asociarListaEsperaACliente(idListaEspera, idCliente);
        return new ResponseEntity<>("Lista de espera asociada al cliente correctamente", HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public List<ListaEspera> obtenerListasEsperaPorEmail(@RequestParam String email) {
        // Buscar al cliente por su correo electrónico
        Optional<Cliente> clienteOptional = clienteRepo.findOptionalClienteByEmail(email);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            List<ListaEspera> listasEspera = new ArrayList<>();
            for (ClienteListaEspera clienteListaEspera : clienteListaRepo.findByCliente(cliente)) {
                listasEspera.add(clienteListaEspera.getListaEspera());
            }
            return listasEspera;
        } else {
            // Manejar el caso en el que el cliente no existe
            return List.of();
        }
    }


}


