package com.example.backend.Modelo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private Set<Solicitud> solicitudes;
}
