package com.example.backend;
import com.example.backend.Modelo.Controladores.ClienteController;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Servicios.ClienteService;
import com.example.backend.Modelo.Utils.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void testIniciarSesion_CredencialesValidas() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setEmail("correo@example.com");
        cliente.setContrasenia("contrasenia");

        // Simulamos que el servicio encuentra al cliente
        when(clienteService.iniciarSesion("correo@example.com", "contrasenia")).thenReturn(cliente);
        // Simulamos la generación de un token
        when(jwtService.generarToken(cliente)).thenReturn("token");

        // Act
        ResponseEntity<?> response = clienteController.iniciarSesion(cliente);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Verificamos que se devuelva un HttpStatus.OK
        assertEquals("token", response.getBody()); // Verificamos que se devuelva el token correcto

        // Verificamos que el método del servicio se haya llamado
        verify(clienteService, times(1)).iniciarSesion("correo@example.com", "contrasenia");
        // Verificamos que el método del servicio se haya llamado para generar el token
        verify(jwtService, times(1)).generarToken(cliente);
    }

    @Test
    public void testIniciarSesion_CredencialesInvalidas() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setEmail("correo@example.com");
        cliente.setContrasenia("contrasenia");

        // Simulamos que el servicio no encuentra al cliente
        when(clienteService.iniciarSesion("correo@example.com", "contrasenia")).thenReturn(null);

        // Act
        ResponseEntity<?> response = clienteController.iniciarSesion(cliente);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode()); // Verificamos que se devuelva un HttpStatus.UNAUTHORIZED
        assertEquals("Credenciales inválidas", response.getBody()); // Verificamos que se devuelva el mensaje de error correcto

        // Verificamos que el método del servicio se haya llamado
        verify(clienteService, times(1)).iniciarSesion("correo@example.com", "contrasenia");
        // Verificamos que el método del servicio para generar el token no se haya llamado
        verifyNoInteractions(jwtService);
    }
}
