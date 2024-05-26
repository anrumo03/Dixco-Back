package com.example.backend.Modelo.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(length = 100)
    private String nombre;
    @Column(length = 100)
    private String apellido;
    @Column(length = 100)
    private String direccion;
    @NotBlank
    @Email
    private String email;
    @Column(length = 100)
    private String contrasenia;
    @Column(length = 10)
    private String telefono;
    private Date fechaNacimiento;
    @ManyToMany(mappedBy = "clientes")
    private Set<ListaEspera> listasEspera;

    // Add the token field (consider using a long text field)
    @Column(length = 500)
    private String token;
}