package com.example.backend.Modelo.Repositorios;

import com.example.backend.Modelo.Entidades.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaEsperaRepo extends JpaRepository<ListaEspera, String> {
}
