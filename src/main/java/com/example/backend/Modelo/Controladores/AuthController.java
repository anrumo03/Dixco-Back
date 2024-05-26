package com.example.backend.Modelo.Controladores;
import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Servicios.ClienteService;
import com.example.backend.Modelo.Servicios.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody Cliente cliente) {
        // Verificar las credenciales del usuario
        boolean credentialsValid = clienteService.verifyCredentials(cliente.getEmail(), cliente.getContrasenia());

        if (credentialsValid) {
            // Si las credenciales son válidas, generar un token JWT
            String email = cliente.getEmail(); // Obtener el email del cliente
            String token = jwtService.generateToken(email); // Generar el token usando el email
            return ResponseEntity.ok(token); // Retornar el token en la respuesta

        } else {
            return ResponseEntity.badRequest().body("Credenciales inválidas");
        }
    }
}
