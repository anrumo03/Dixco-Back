package com.example.backend.Modelo.Utils;

import com.example.backend.Modelo.Entidades.Cliente;
import com.example.backend.Modelo.Entidades.Administrador;
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
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", cliente.getNombre());
        claims.put("apellido", cliente.getApellido());
        claims.put("telefono", cliente.getTelefono());
        claims.put("contrasenia", cliente.getContrasenia());
        claims.put("direccion", cliente.getDireccion());
        claims.put("role", "CLIENTE");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(cliente.getIdCliente().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String generarToken(Administrador administrador) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombreUsuario", administrador.getNombreUsuario());
        claims.put("nivelAcceso", administrador.getNivelAcceso().toString());
        claims.put("role", "ADMIN");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(administrador.getIdAdmin().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
