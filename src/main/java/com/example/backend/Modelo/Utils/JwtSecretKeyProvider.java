package com.example.backend.Modelo.Utils;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtSecretKeyProvider {

    @Value("${jwt.secreto}")
    private String jwtSecreto;

    public String generarNuevaClave() {
        // Generar una nueva clave segura para HS512
        SecretKey claveSecreta = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        // Codificar la clave secreta a Base64
        String nuevaClave = Encoders.BASE64.encode(claveSecreta.getEncoded());

        // Reemplazar la clave existente en application.properties
        jwtSecreto = nuevaClave;

        return nuevaClave;
    }

    // Método para obtener la clave secreta actual
    public String getJwtSecreto() {
        return jwtSecreto;
    }
}

