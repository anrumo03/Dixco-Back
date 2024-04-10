package com.example.backend.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ReservaDTO {

    @NotNull
    private Long idReserva;
    @NotNull
    private Date fecha;
    @NotNull
    private ClienteDTO cliente;
    @NotNull
    private MesaDTO mesaReservada;
    @NotNull
    private int cantidadPersonas;
    @NotNull
    private String estado;
}
