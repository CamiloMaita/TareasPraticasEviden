package com.ejercicio.ClubNautico.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.ClubNautico.entity.Barco;
import com.ejercicio.ClubNautico.entity.Socio;
import com.ejercicio.ClubNautico.service.BarcoService;
import com.ejercicio.ClubNautico.service.SocioService;

import java.util.List;

@RestController
@RequestMapping("/api/barcos")
public class BarcoController {
    @Autowired
    private BarcoService barcoService;

    @Autowired
    private SocioService socioService;

    /**
     * Crea un nuevo barco y lo asocia a un socio existente.
     * @param barco Objeto Barco a crear.
     * @param socioId ID del socio al que se asociará el barco.
     * @return Barco creado.
     */
    @PostMapping("/create/{socioId}")
    public Barco createNewBarco(@RequestBody Barco barco, @PathVariable Long socioId) {
        barco.setId(null); // Asegurarse de que el ID sea nulo para que sea autogenerado
        if (barco.getMatricula() == null || barco.getNombre() == null) {
            throw new IllegalArgumentException("Matrícula y nombre no pueden ser nulos");
        }
        
        Socio socio = socioService.getSocioById(socioId);
        if (socio == null) {
            throw new IllegalArgumentException("No se encontró un socio con el ID proporcionado");
        }
        
        barco.setSocio(socio);
        return barcoService.saveBarco(barco);
    }

    /**
     * Obtiene todos los barcos.
     * @return Lista de todos los barcos.
     */
    @GetMapping("/all")
    public List<Barco> getAllBarcos() {
        return barcoService.getAllBarcos();
    }

    /**
     * Obtiene un barco por su ID.
     * @param id ID del barco.
     * @return Barco con el ID especificado.
     */
    @GetMapping("/{id}")
    public Barco getBarcoById(@PathVariable Long id) {
        return barcoService.getBarcoById(id);
    }

    /**
     * Elimina un barco por su ID.
     * @param id ID del barco a eliminar.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteBarcoById(@PathVariable Long id) {
        barcoService.deleteBarco(id);
    }
}

