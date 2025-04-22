package com.ejercicio.ClubNautico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.ClubNautico.entity.Salida;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long> {
    @Query("SELECT s FROM Salida s WHERE s.destino = :destino")
    List<Salida> findSalidasByDestino(@Param("destino") String destino);
}
