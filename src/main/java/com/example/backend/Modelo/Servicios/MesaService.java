package com.example.backend.Modelo.Servicios;

import com.example.backend.Modelo.Entidades.Mesa;
import com.example.backend.Modelo.Enumeraciones.EstadoMesa;
import com.example.backend.Modelo.Repositorios.MesaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    @Autowired
    private MesaRepo mesaRepository;

    public Mesa actualizarEstadoMesa(Long idMesa, EstadoMesa nuevoEstado) {
        Mesa mesa = mesaRepository.findById(idMesa).orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
        mesa.setEstado(nuevoEstado);
        return mesaRepository.save(mesa);
    }
}
