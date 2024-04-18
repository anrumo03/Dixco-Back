package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.EstadoMesa;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mesa {

    @Id
    private Long idMesa;
    private String ubicacion;
    private int capacidad;
    private EstadoMesa estado;
    @OneToMany(mappedBy = "mesaReservada")
    private Set<Reserva> reservas;
}
