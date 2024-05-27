package com.example.backend;

import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Repositorios.ClienteRepo;
import com.example.backend.Modelo.Servicios.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepo clienteRepo;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testRegistrarCliente() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setEmail("correo@example.com");
        cliente.setContrasenia("contrasenia");

        when(clienteRepo.findByEmail("correo@example.com")).thenReturn(null); // Simulamos que no existe un cliente con este correo
        when(clienteRepo.save(cliente)).thenReturn(cliente); // Simulamos que el cliente se guarda correctamente

        // Act
        Cliente clienteRegistrado = clienteService.registrarCliente(cliente);

        // Assert
        assertNotNull(clienteRegistrado); // Verificamos que se haya devuelto un cliente registrado
        assertEquals("correo@example.com", clienteRegistrado.getEmail()); // Verificamos que el correo sea el mismo
        assertEquals("contrasenia", clienteRegistrado.getContrasenia()); // Verificamos que la contraseña sea la misma

        verify(clienteRepo, times(1)).findByEmail("correo@example.com"); // Verificamos que se haya llamado al método findByEmail del repositorio una vez
        verify(clienteRepo, times(1)).save(cliente); // Verificamos que se haya llamado al método save del repositorio una vez

        // Mensaje de éxito o fracaso del registro
        if (clienteRegistrado != null) {
            System.out.println("¡Cliente registrado exitosamente!");
        } else {
            System.out.println("¡Error al registrar el cliente!");
        }
    }
}
