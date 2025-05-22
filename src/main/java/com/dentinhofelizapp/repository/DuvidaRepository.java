package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Duvida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface DuvidaRepository extends MongoRepository<Duvida, String> {
}