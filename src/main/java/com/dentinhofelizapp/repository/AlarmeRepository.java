package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Alarme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlarmeRepository extends MongoRepository<Alarme, String> {
}
