package com.example.backend.Modelo.Controladores;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.ListaEspera;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Repositorios.ListaEsperaRepo;
import com.example.backend.Modelo.Repositorios.ReservaRepo;
import com.example.backend.Modelo.Servicios.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/lista-espera")
public class ListaEsperaController {

    private final ListaEsperaService listaEsperaService;

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
        // Llama al servicio para asociar la lista de espera al cliente
        listaEsperaService.asociarListaEsperaACliente(idListaEspera, idCliente);
        return new ResponseEntity<>("Lista de espera asociada al cliente correctamente", HttpStatus.OK);
    }

}


