package com.example.backend.Modelo.Entidades;

import com.example.backend.Enumeraciones.NivelAcceso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Administrador {

    @Id
    private Long idAdmin;
    @Column(length=100)
    private String nombreUsuario;
    @Column(length=100)
    private String contrasenia;
    @Column
    private NivelAcceso nivelAcceso;
    @NotBlank
    @Email
    private String email;
}
