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
    private String idCliente;
    @Column(length=100)
    private String nombre;
    @Column(length=100)
    private String apellido;
    @Column(length=100)
    private String direccion;
    @NotBlank
    @Email
    private String email;
    @Column(length=100)
    private String contrasenia;
    @Column(length=10)
    private String telefono;
    private Date fechaNacimiento;
    @ManyToMany(mappedBy = "clientes")
    private Set<ListaEspera> listasEspera;
    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;
    @OneToMany(mappedBy = "cliente")
    private Set<Notificacion> notificaciones;
}
