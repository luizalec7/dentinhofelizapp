package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.Alarme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmeRepository extends JpaRepository<Alarme, Long> {
}

