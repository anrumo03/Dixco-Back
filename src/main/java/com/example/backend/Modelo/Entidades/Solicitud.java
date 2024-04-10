package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.EstadoSolicitud;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}
