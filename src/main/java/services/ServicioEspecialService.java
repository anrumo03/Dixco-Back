package services;

import com.example.backend.Modelo.Entidades.ServicioEspecial;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.ServicioEspecialRepo;
import services.excepciones.Excepcion;

@Service
@Transactional
@AllArgsConstructor
public class ServicioEspecialService implements ServicioEspecialIn{
    private final ServicioEspecialRepo servicioEspecialRepo;
    @Override
    public ServicioEspecial crearServicio(ServicioEspecial servicioEspecial) throws Exception {
        try{

            return servicioEspecialRepo.save(servicioEspecial);
        }
        catch (Exception e) {
            System.out.println("No se ha podido registrar el servicio especial en la base de datos");
            return null;
        }
    }

    @Override
    public void eliminarServicio(ServicioEspecial servicioEspecial) throws Exception {
        if(servicioEspecialRepo.findById(servicioEspecial.getIdServicioEspecial()).isPresent()){
            servicioEspecialRepo.deleteById(servicioEspecial.getIdServicioEspecial());
        }
        else{
            throw new Excepcion("El servicio no se encuentra en la base de datos");
        }

    }

    @Override
    public ServicioEspecial modificarServicio(ServicioEspecial servicioEspecial) throws Exception {
        if(servicioEspecialRepo.findById(servicioEspecial.getIdServicioEspecial()).isPresent()){
            return servicioEspecialRepo.save(servicioEspecial);
        }
        else{
            throw new Excepcion("El servicio no se encuentra en la base de datos");
        }
    }
}
