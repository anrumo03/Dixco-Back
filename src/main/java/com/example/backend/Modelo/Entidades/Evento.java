package com.example.backend.Modelo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento {

    @Id
    private Long idEvento;
    private Date fecha;
    private String tipoEvento;
    @ManyToMany
    private Set<Reserva> reservas;
}
