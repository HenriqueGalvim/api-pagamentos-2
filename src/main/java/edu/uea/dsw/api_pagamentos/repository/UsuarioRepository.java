package edu.uea.dsw.api_pagamentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uea.dsw.api_pagamentos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}