package com.example.backend.Modelo.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicioEspecial {

    @Id
    private String idServicioEspecial;
    private String nombreServicio;
    private double costoServicio;
    @ManyToMany
    @JoinTable(
            name = "solicitud_servicio",
            joinColumns = @JoinColumn(name = "servicio_id"),
            inverseJoinColumns = @JoinColumn(name = "solicitud_id")
    )
    private Set<Solicitud> solicitudes;
}
