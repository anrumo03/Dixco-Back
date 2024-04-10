package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepo extends JpaRepository<Mesa, String> {
}
