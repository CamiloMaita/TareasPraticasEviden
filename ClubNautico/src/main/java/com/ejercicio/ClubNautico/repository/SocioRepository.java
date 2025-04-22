package com.ejercicio.ClubNautico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.ClubNautico.entity.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
	
}
