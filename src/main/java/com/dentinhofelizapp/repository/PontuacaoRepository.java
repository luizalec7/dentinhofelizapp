package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Pontuacao;
import com.dentinhofelizapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {
    List<Pontuacao> findByUsuario(Usuario usuario);
}
