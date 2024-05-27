package com.example.backend.Modelo.Servicios;

import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Entidades.ServiciosEspeciales;
import com.example.backend.Modelo.Entidades.Solicitud;
import com.example.backend.Modelo.Enumeraciones.EstadoReserva;
import com.example.backend.Modelo.Enumeraciones.EstadoSolicitud;
import com.example.backend.Modelo.Repositorios.ServiciosEspecialesRepo;
import com.example.backend.Modelo.Repositorios.SolicitudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepo solicitudRepositorio;

    @Autowired
    private ServiciosEspecialesRepo serviciosEspecialesRepo;

    public Solicitud registrarSolicitud(Solicitud solicitud) {
        solicitud.setEstado(EstadoSolicitud.PENDIENTE);

        Solicitud nuevaSolicitud = solicitudRepositorio.save(solicitud);
        nuevaSolicitud.setEstado(EstadoSolicitud.APROBADA);
        solicitudRepositorio.save(nuevaSolicitud);

        return solicitudRepositorio.save(solicitud);
    }

}