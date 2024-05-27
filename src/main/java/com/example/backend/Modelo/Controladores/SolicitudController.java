package com.example.backend.Modelo.Controladores;

import com.example.backend.Modelo.Entidades.Reserva;
import com.example.backend.Modelo.Entidades.ServiciosEspeciales;
import com.example.backend.Modelo.Entidades.Solicitud;
import com.example.backend.Modelo.Repositorios.ServiciosEspecialesRepo;
import com.example.backend.Modelo.Repositorios.SolicitudRepo;
import com.example.backend.Modelo.Servicios.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudServicio;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudServicio.registrarSolicitud(solicitud);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }
}