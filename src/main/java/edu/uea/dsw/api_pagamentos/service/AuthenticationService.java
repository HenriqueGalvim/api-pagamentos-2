package edu.uea.dsw.api_pagamentos.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.uea.dsw.api_pagamentos.dto.LoginRequestDTO;
import edu.uea.dsw.api_pagamentos.model.Usuario;
import edu.uea.dsw.api_pagamentos.repository.UsuarioRepository;

public class AuthenticationService {

    private final UsuarioRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UsuarioRepository userRepository,
        AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public Usuario authenticate(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword()
            )
        );

        return userRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
