package com.example.backend;
import com.example.backend.Modelo.Controladores.MesaController;
import com.example.backend.Modelo.Entidades.Mesa;
import com.example.backend.Modelo.Enumeraciones.EstadoMesa;
import com.example.backend.Modelo.Repositorios.MesaRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MesaControllerTest {

    @Mock
    private MesaRepo mesaRepo;

    @InjectMocks
    private MesaController mesaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtenerTodasLasMesas_DeberiaRetornarTodasLasMesas() {
        // Configurar el comportamiento simulado del repositorio MesaRepo
        Mesa mesa1 = new Mesa(1L, "Ubicacion1", 5, EstadoMesa.LIBRE);
        Mesa mesa2 = new Mesa(2L, "Ubicacion2", 5, EstadoMesa.FUERASERVICIO);
        List<Mesa> mesas = Arrays.asList(mesa1, mesa2);
        when(mesaRepo.findAll()).thenReturn(mesas);

        // Ejecutar el método a probar
        List<Mesa> resultado = mesaController.obtenerTodasLasMesas();

        System.out.println("Mesas obtenidas:");
        resultado.forEach(System.out::println);

        // Verificar el resultado
        assertEquals(mesas.size(), resultado.size());
        assertEquals(mesas.get(0), resultado.get(0));
        assertEquals(mesas.get(1), resultado.get(1));
    }

}

