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

    public Optional<Cliente> findByEmailAndPassword(String email, String contrasena) {
        return clienteRepo.findByEmailAndContrasenia(email, contrasena);
    }

    public boolean verifyCredentials(String email, String contrasenia) {
        Optional<Cliente> cliente = findByEmailAndPassword(email, contrasenia);
        return cliente.isPresent();
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
}
