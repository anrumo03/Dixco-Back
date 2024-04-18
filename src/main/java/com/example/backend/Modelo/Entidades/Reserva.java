package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.EstadoReserva;
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
public class Reserva {

    @Id
    private String idReserva;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesaReservada;
    private int cantidadPersonas;
    private EstadoReserva estado;
    @OneToMany(mappedBy = "reserva")
    private Set<Solicitud> solicitudes;

    /*@ManyToOne
    private Evento evento;*/
}
