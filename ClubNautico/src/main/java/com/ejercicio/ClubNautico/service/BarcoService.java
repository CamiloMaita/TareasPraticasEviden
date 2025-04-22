package com.ejercicio.ClubNautico.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.ClubNautico.entity.Barco;
import com.ejercicio.ClubNautico.repository.BarcoRepository;

import java.util.List;

@Service
public class BarcoService {
    @Autowired
    private BarcoRepository barcoRepository;

    public Barco saveBarco(Barco barco) {
        if (barco.getMatricula() == null || barco.getNombre() == null) {
            throw new IllegalArgumentException("Matrícula y nombre no pueden ser nulos");
        }
        return barcoRepository.save(barco);
    }

    public List<Barco> getAllBarcos() {
        return barcoRepository.findAll();
    }

    public Barco getBarcoById(Long id) {
        return barcoRepository.findById(id).orElse(null);
    }

    public void deleteBarco(Long id) {
        barcoRepository.deleteById(id);
    }
}