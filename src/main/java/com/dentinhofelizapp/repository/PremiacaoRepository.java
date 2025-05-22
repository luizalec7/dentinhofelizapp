package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Premiacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PremiacaoRepository extends MongoRepository<Premiacao, String> {
}

