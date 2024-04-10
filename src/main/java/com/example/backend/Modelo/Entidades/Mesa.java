package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.EstadoMesa;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mesa {

    @Id
    private Long idMesa;
    private String ubicacion;
    private int capacidad;
    private EstadoMesa estado;
}
