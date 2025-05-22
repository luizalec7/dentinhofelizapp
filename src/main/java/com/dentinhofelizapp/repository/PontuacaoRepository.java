package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Pontuacao;
import com.dentinhofelizapp.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PontuacaoRepository extends MongoRepository<Pontuacao, String> {
    List<Pontuacao> findByUsuario(Usuario usuario); // Agora suportado corretamente
}