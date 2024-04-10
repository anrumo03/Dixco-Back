package com.example.backend.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MesaDTO {

    @NotNull
    private Long idMesa;
    @NotNull
    private String ubicacion;
    @NotNull
    private int capacidad;
    @NotNull
    private String estado;
}
