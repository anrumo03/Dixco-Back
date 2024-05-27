package com.example.backend.Modelo.Controladores;

import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/obtener/reservas")
public class ObtenerReservasController {

    private final ReservaService reservaService;

    @Autowired
    public ObtenerReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Reserva>> obtenerReservasPorCorreo(@RequestParam String email) {
        List<Reserva> reservas = reservaService.obtenerReservasPorCorreo(email);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}

