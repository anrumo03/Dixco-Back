package services;

import com.example.backend.Modelo.Entidades.Solicitud;
import org.springframework.stereotype.Service;

@Service
public interface SolicitudIn {
    Solicitud crearSolicitud (Solicitud solicitud) throws Exception;
    void eliminarSolicitud (Solicitud solicitud) throws Exception;
    double calcularCosto (Solicitud solicitud) throws Exception;

}
