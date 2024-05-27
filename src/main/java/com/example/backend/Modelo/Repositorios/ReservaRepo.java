package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, String> {
    List<Reserva> findByClienteEmail(String email);
}
