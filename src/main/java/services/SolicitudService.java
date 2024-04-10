package services;

import com.example.backend.Modelo.Entidades.ServicioEspecial;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SolicitudService implements ServicioEspecialIn {
    @Override
    public ServicioEspecial crearServicio(ServicioEspecial servicioEspecial) throws Exception {
        return null;
    }

    @Override
    public void eliminarServicio(ServicioEspecial servicioEspecial) throws Exception {

    }

    @Override
    public ServicioEspecial modificarServicio(ServicioEspecial servicioEspecial) throws Exception {
        return null;
    }
}
