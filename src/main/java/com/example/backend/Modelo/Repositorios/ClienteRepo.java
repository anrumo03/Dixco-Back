package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {
}
