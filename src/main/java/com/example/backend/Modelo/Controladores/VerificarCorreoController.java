package com.example.backend.Modelo.Controladores;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verificar-correo")
public class VerificarCorreoController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{correo}")
    public ResponseEntity<?> verificarCorreo(@PathVariable String correo) {
        Cliente cliente = clienteService.buscarClientePorCorreo(correo);
        if (cliente != null) {
            // Si el usuario existe, se devuelve un estado 200 OK
            return ResponseEntity.ok().build();
        } else {
            // Si el usuario no existe, se devuelve un estado 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

