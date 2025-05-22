package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}