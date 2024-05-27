package com.example.backend.Modelo.Servicios;

import com.example.backend.Modelo.Enumeraciones.EstadoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Repositorios.ReservaRepo;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepo reservaRepository;

    @Autowired
    public ReservaService(ReservaRepo reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva) {

        reserva.setEstado(EstadoReserva.PENDIENTE);

        // Guarda la reserva en la base de datos
        Reserva nuevaReserva = reservaRepository.save(reserva);

        // Actualiza el estado de la reserva a "CONFIRMADA" después de guardarla en la base de datos
        nuevaReserva.setEstado(EstadoReserva.CONFIRMADA);
        reservaRepository.save(nuevaReserva); // Guarda la reserva actualizada en la base de datos

        return nuevaReserva;
    }

    // Método para buscar reservas por correo electrónico del cliente
    public List<Reserva> obtenerReservasPorCorreo(String email) {
        return reservaRepository.findByClienteEmail(email);
    }
}
