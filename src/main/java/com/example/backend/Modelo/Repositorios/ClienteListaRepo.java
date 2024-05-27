package com.example.backend.Modelo.Repositorios;


import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.ClienteListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteListaRepo extends JpaRepository<ClienteListaEspera, Long> {
    List<ClienteListaEspera> findByCliente(Cliente cliente);
}