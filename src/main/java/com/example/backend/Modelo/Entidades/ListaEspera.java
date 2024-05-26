package com.example.backend.Modelo.Entidades;

import com.example.backend.Modelo.Enumeraciones.EstadoLista;
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
            name = "cliente_lista_espera",
            joinColumns = @JoinColumn(name = "id_lista_espera"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente")
    )
    private Set<Cliente> clientes;

    private String idMesaSolicitada;
    private LocalDateTime fecha;
    private EstadoLista estado;
}