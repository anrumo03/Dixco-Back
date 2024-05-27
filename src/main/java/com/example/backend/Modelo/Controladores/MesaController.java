package com.example.backend.Modelo.Controladores;
import com.example.backend.Modelo.Entidades.Mesa;
import com.example.backend.Modelo.Repositorios.MesaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    private final MesaRepo mesaRepository;

    @Autowired
    public MesaController(MesaRepo mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping
    public List<Mesa> obtenerTodasLasMesas() {
        return mesaRepository.findAll();
    }

    @GetMapping("/buscar-mesas/{id}")
    public ResponseEntity<Mesa> obtenerMesaPorId(@PathVariable Long id) {
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        if (mesa != null) {
            return new ResponseEntity<>(mesa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

