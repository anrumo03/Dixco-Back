package com.example.backend.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Data
public class AdministradorDTO {

    @NotNull
    private Long idAdmin;
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String contrasenia;
    @NotNull
    private String nivelAcceso;
    @NotNull
    private String email;
}
