package com.ejercicio.ClubNautico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.ClubNautico.entity.Barco;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Long> {
}
