package com.example.backend.Modelo.Controladores;

import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Servicios.ClienteService;
import com.example.backend.Modelo.Servicios.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    JwtService jwtService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteRegistrado = clienteService.registrarCliente(cliente);

        // Generate JWT after successful registration
        String token = jwtService.generateToken(clienteRegistrado.getEmail());

        // Store token in the database
        clienteRegistrado.setToken(token);
        clienteRegistrado = clienteService.updateCliente(clienteRegistrado);

        // Create a custom class to hold the client and token
        RegistrationResponse response = new RegistrationResponse(clienteRegistrado, token);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

// Custom class to return client and token
class RegistrationResponse {
    Cliente cliente;
    String token;

    public RegistrationResponse(Cliente cliente, String token) {
        this.cliente = cliente;
        this.token = token;
    }
}