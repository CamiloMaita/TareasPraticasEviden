package com.ejercicio.ClubNautico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.ClubNautico.entity.Socio;
import com.ejercicio.ClubNautico.repository.SocioRepository;



import java.util.List;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;

    @Transactional
    public Socio saveSocio(Socio socio) {
        if (socio.getNombre() == null || socio.getDireccion() == null) {
            throw new IllegalArgumentException("Nombre y dirección no pueden ser nulos");
        }
        return socioRepository.save(socio);
    }

    @Transactional(readOnly = true)
    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Socio getSocioById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }
}
