package com.example.backend.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ClienteDTO {

    @NotNull
    private Long idCliente;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String direccion;
    @NotNull
    private String email;
    @NotNull
    private String contrasenia;
    @NotNull
    private String telefono;
    private Date fechaNacimiento;
    private Set<ListaEsperaDTO> listasEspera;
}
