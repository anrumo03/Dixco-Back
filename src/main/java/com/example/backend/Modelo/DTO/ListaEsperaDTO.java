package com.example.backend.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Data
public class ListaEsperaDTO {

    @NotNull
    private Long idLista;
    @NotNull
    private Set<ClienteDTO> clientes;
    @NotNull
    private Long idMesaSolicitada;
    @NotNull
    private LocalDateTime fecha;
    @NotNull
    private String estado;
}
