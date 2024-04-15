package services;

import com.example.backend.Modelo.Entidades.Reserva;
import org.springframework.stereotype.Service;

@Service
public interface ReservaIn {
    Reserva crearReserva (Reserva reserva) throws Exception;
    void eliminarReserva (Reserva reserva) throws Exception;
    Reserva modificarReserva (Reserva reserva) throws Exception;
}
