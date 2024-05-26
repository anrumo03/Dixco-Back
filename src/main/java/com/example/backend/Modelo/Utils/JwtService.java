package com.example.backend.Modelo.Utils;

import com.example.backend.Modelo.Entidades.Cliente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Autowired
    private JwtSecretKeyProvider jwtSecretKeyProvider;

    private String secreto;
    private Key key;

    @PostConstruct
    public void init() {
        secreto = jwtSecretKeyProvider.getJwtSecreto();
        byte[] decodedKey;
        if (secreto.length() < 64) {
            secreto = jwtSecretKeyProvider.generarNuevaClave();
            key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secreto));
        } else {
            decodedKey = Base64.getDecoder().decode(secreto);
            key = Keys.hmacShaKeyFor(decodedKey);
        }
    }

    public String generarToken(Cliente cliente) {
        // Crea un mapa para los claims del token
        Map<String, Object> claims = new HashMap<>();
        // Agrega el nombre del cliente al mapa
        claims.put("nombre", cliente.getNombre());
        // Construye el token con el nombre del cliente en el payload
        return Jwts.builder()
                .setClaims(claims) // Incluir los claims
                .setSubject(cliente.getIdCliente().toString()) // Establecer el ID del cliente como el sujeto del token
                .setIssuedAt(new Date()) // Establecer la fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // Establecer la fecha de expiración (1 hora)
                .signWith(key, SignatureAlgorithm.HS512) // Firmar el token usando el secreto y el algoritmo HS512
                .compact();
    }
}