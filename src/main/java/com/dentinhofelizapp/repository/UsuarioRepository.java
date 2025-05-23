package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}