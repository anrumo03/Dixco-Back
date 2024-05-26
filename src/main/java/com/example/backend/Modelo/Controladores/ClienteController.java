    package com.example.backend.Modelo.Controladores;
    
    import com.example.backend.Modelo.Entidades.Cliente;
    import com.example.backend.Modelo.Servicios.ClienteService;
    import com.example.backend.Modelo.Utils.JwtService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.HashMap;


    @RestController
    @RequestMapping("/api/cliente")
    @CrossOrigin(origins = "http://localhost:3000")
    public class ClienteController {
    
        @Autowired
        private ClienteService clienteService;
    
        @Autowired
        private JwtService jwtService;

        @PostMapping("/registrar")
        @CrossOrigin(origins = "http://localhost:3000")
        public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
            Cliente clienteRegistrado = clienteService.registrarCliente(cliente); // Aquí se guarda el cliente en la base de datos
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteRegistrado); // Devuelve el cliente registrado como respuesta
        }
        @PostMapping("/iniciarSesion")
        public ResponseEntity<?> iniciarSesion(@RequestBody Cliente cliente) {
            Cliente clienteEncontrado = clienteService.iniciarSesion(cliente.getEmail(), cliente.getContrasenia());
            if (clienteEncontrado != null) {
                // Generar token
                String token = jwtService.generarToken(clienteEncontrado);
                return ResponseEntity.ok().body(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        }
    
    
    }
