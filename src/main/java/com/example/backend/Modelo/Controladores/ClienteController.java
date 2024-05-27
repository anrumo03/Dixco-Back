    package com.example.backend.Modelo.Controladores;
    
    import com.example.backend.Modelo.Entidades.Cliente;
    import com.example.backend.Modelo.Repositorios.ClienteRepo;
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

        private final ClienteRepo clienteRepo;

        @Autowired
        public ClienteController(ClienteRepo clienteRepo) {
            this.clienteRepo = clienteRepo;
        }

        @Autowired
        private JwtService jwtService;

        @PostMapping("/registrar")
        @CrossOrigin(origins = "http://localhost:3000")
        public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
            try {
                Cliente nuevoCliente = clienteService.registrarCliente(cliente);
                return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
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

        @GetMapping("/buscar-correo/{correo}")
        public ResponseEntity<Cliente> buscarClientePorCorreo(@PathVariable String correo) {
            Cliente cliente = clienteService.buscarClientePorCorreo(correo);
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    
    }
