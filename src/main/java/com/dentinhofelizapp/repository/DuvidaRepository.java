package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Duvida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {
}
