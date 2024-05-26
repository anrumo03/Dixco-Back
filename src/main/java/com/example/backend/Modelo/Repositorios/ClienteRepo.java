package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmailAndContrasenia(String email, String contrasenia);
}
