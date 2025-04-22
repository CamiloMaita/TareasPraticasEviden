package com.ejercicio.ClubNautico.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.ClubNautico.entity.Socio;
import com.ejercicio.ClubNautico.service.SocioService;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private SocioService socioService;

    /**
     * Crea un nuevo socio.
     * @param socio Objeto Socio a crear.
     * @return Socio creado.
     */
    @PostMapping("/create")
    public Socio createNewSocio(@RequestBody Socio socio) {
        socio.setId(null); // Asegurarse de que el ID sea nulo para que sea autogenerado
        if (socio.getNombre() == null || socio.getDireccion() == null) {
            throw new IllegalArgumentException("Nombre y dirección no pueden ser nulos");
        }
        return socioService.saveSocio(socio);
    }

    /**
     * Obtiene todos los socios.
     * @return Lista de todos los socios.
     */
    @GetMapping("/all")
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    /**
     * Obtiene un socio por su ID.
     * @param id ID del socio.
     * @return Socio con el ID especificado.
     */
    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id);
    }

    /**
     * Elimina un socio por su ID.
     * @param id ID del socio a eliminar.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteSocioById(@PathVariable Long id) {
        socioService.deleteSocio(id);
    }
}
