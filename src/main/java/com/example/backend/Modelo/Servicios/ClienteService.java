package com.example.backend.Modelo.Servicios;


import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Repositorios.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public Cliente registrarCliente(Cliente cliente) {
        cliente.setIdCliente(null);
        return clienteRepo.save(cliente);
    }

    public Cliente iniciarSesion(String email, String contrasenia) {
        Cliente cliente = clienteRepo.findByEmail(email);
        if (cliente != null && cliente.getContrasenia().equals(contrasenia)) {
            return cliente;
        } else {
            return null;
        }
    }

}
