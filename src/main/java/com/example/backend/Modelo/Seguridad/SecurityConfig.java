package com.example.backend.Modelo.Seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/api/cliente/registrar")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/cliente/iniciarSesion")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/mesas")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/reservas")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/mesas/buscar-mesas/{id}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/cliente/buscar-correo/{correo}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/solicitudes/registrar")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/solicitudes/crear")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/solicitudes")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/servicios-especiales")).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable());
        return http.build();
    }
}

