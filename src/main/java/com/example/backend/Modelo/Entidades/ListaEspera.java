package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.EstadoLista;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private Set<Cliente> clientes;
    private String idMesaSolicitada;
    private LocalDateTime fecha;
    private EstadoLista estado;
}
