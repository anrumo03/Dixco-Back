package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.EstadoSolicitud;
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
    private Long idSolicitud;
    private String idCliente;
    private String tipo;
    private String detalles;
    private EstadoSolicitud estado;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    @ManyToMany(mappedBy = "servicios")
    private Set<ServicioEspecial> servicioEspecialSet;
}
