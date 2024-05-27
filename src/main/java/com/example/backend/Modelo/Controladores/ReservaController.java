package com.example.backend.Modelo.Controladores;

import com.example.backend.Modelo.Entidades.Mesa;
import com.example.backend.Modelo.Enumeraciones.EstadoMesa;
import com.example.backend.Modelo.Servicios.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Servicios.ReservaService;

@RestController
public class ReservaController {

    private final ReservaService reservaService;
    private final MesaService mesaService;


    @Autowired
    public ReservaController(ReservaService reservaService, MesaService mesaService) {
        this.reservaService = reservaService;
        this.mesaService = mesaService;
    }

    @PostMapping("/api/reservas")
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);

        Mesa mesaActualizada = mesaService.actualizarEstadoMesa(reserva.getMesaReservada().getIdMesa(), EstadoMesa.RESERVADA);

        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

}
