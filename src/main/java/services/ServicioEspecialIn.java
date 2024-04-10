package services;

import com.example.backend.Modelo.Entidades.ServicioEspecial;
import org.springframework.stereotype.Service;

@Service
public interface ServicioEspecialIn {

    ServicioEspecial crearServicio (ServicioEspecial servicioEspecial) throws Exception;
    void eliminarServicio (ServicioEspecial servicioEspecial) throws Exception;
    ServicioEspecial modificarServicio (ServicioEspecial servicioEspecial) throws Exception;
}
