package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.EstadoReserva;
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
public class Reserva {

    @Id
    private Long idReserva;
    private Date fecha;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Mesa mesaReservada;
    private int cantidadPersonas;
    private EstadoReserva estado;
}
