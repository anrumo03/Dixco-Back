package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Administrador;
import com.example.backend.Modelo.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, String> {
    Administrador findByEmail(String email);

}
