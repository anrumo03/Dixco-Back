package com.example.backend.Modelo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notificacion {

    @Id
    private Long idNotificacion;
    @ManyToOne
    private Cliente destinatario;
    private String contenido;
    private Date fecha;
}
