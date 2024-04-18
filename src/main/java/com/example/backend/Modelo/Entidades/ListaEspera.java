package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.EstadoLista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListaEspera {

    @Id
    private Long idLista;
    @ManyToMany
    @JoinTable(
            name = "clientes_listas",
            joinColumns = @JoinColumn(name = "listaEspera_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private Set<Cliente> clientes;
    @OneToMany(mappedBy = "listaEspera")
    private Set<Notificacion> notificaciones;
    private String idMesaSolicitada;
    private LocalDateTime fecha;
    private EstadoLista estado;
}
