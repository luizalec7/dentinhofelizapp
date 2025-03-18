package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Premiacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiacaoRepository extends JpaRepository<Premiacao, Long> {
}

