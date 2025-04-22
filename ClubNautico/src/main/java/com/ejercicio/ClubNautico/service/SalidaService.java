package com.ejercicio.ClubNautico.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.ClubNautico.entity.Salida;
import com.ejercicio.ClubNautico.repository.SalidaRepository;

import java.util.List;

@Service
public class SalidaService {
    @Autowired
    private SalidaRepository salidaRepository;

    public Salida saveSalida(Salida salida) {
        if (salida.getFechaHoraSalida() == null || salida.getDestino() == null) {
            throw new IllegalArgumentException("Fecha y hora de salida y destino no pueden ser nulos");
        }
        return salidaRepository.save(salida);
    }

    public List<Salida> getAllSalidas() {
        return salidaRepository.findAll();
    }

    public Salida getSalidaById(Long id) {
        return salidaRepository.findById(id).orElse(null);
    }

    public void deleteSalida(Long id) {
        salidaRepository.deleteById(id);
    }

    public List<Salida> findSalidasByDestino(String destino) {
        return salidaRepository.findSalidasByDestino(destino);
    }
}
