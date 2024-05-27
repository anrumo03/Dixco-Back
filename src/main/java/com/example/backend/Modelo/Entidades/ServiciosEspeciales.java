package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.TipoServicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiciosEspeciales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idServicio;
    @Column(length = 200)
    private String nombre_servicio;
    private Float costo;

    private TipoServicio tipo;

    @ManyToMany
    @JoinTable(
            name = "solicitud_servicios_especiales",
            joinColumns = @JoinColumn(name = "id_servicio"),
            inverseJoinColumns = @JoinColumn(name = "id_solicitud")
    )
    private Set<Solicitud> solicitud;

}
