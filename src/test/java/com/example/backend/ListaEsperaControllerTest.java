package com.example.backend;
import com.example.backend.Modelo.Controladores.ListaEsperaController;
import com.example.backend.Modelo.Entidades.ListaEspera;
import com.example.backend.Modelo.Servicios.ListaEsperaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ListaEsperaControllerTest {

    @Mock
    private ListaEsperaService listaEsperaService;

    @InjectMocks
    private ListaEsperaController listaEsperaController;

    @Test
    public void testApuntarseListaEspera() {
        // Arrange
        ListaEspera listaEspera = new ListaEspera();
        listaEspera.setIdLista(1L);
        // Simulamos que la lista de espera se crea correctamente
        when(listaEsperaService.crearLista(listaEspera)).thenReturn(listaEspera);

        // Act
        ResponseEntity<ListaEspera> response = listaEsperaController.apuntarseListaEspera(listaEspera);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode()); // Verificamos que el estado de la respuesta sea 201 CREATED
        assertEquals(listaEspera, response.getBody()); // Verificamos que la lista de espera devuelta sea la misma que la creada
        verify(listaEsperaService, times(1)).crearLista(listaEspera); // Verificamos que se haya llamado al método crearLista del servicio una vez
    }
}

