package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepo extends JpaRepository<Solicitud, Long> {
}
