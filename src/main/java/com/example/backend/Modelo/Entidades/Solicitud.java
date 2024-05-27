package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.EstadoSolicitud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitud;
    private Long idCliente;
    private EstadoSolicitud estado;
    private Date fecha;

    @ManyToMany(mappedBy = "solicitud")
    private Set<ServiciosEspeciales> serviciosEspeciales;

}
