package services;

import com.example.backend.Modelo.Entidades.Reserva;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.ReservaRepo;
import services.excepciones.Excepcion;

@Service
@Transactional
@AllArgsConstructor
public class ReservaService implements ReservaIn {

    private final ReservaRepo reservaRepo;
    @Override
    public Reserva crearReserva(Reserva reserva) throws Exception {
        try{

            return reservaRepo.save(reserva);
        }
        catch (Exception e) {
            System.out.println("No se ha podido registrar la reserva en la base de datos");
            return null;
        }
    }

    @Override
    public void eliminarReserva(Reserva reserva) throws Exception {
        if(reservaRepo.findById(reserva.getIdReserva()).isPresent()){
            reservaRepo.deleteById(reserva.getIdReserva());
        }
        else{
            throw new Excepcion("La reserva no se encuentra en la base de datos");
        }
    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {
        if(reservaRepo.findById(reserva.getIdReserva()).isPresent()){
            return reservaRepo.save(reserva);
        }
        else{
            throw new Excepcion("La reserva no se encuentra en la base de datos");
        }
    }
}
