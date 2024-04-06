package com.example.backend.Modelo.Entidades;

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
    private String idSolicitud;
    private String idCliente;
    private String tipo;
    private String detalles;
    private String estado;
    private Date fecha;
}
