package com.ejercicio.ClubNautico.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.ClubNautico.entity.Barco;
import com.ejercicio.ClubNautico.entity.Salida;
import com.ejercicio.ClubNautico.service.BarcoService;
import com.ejercicio.ClubNautico.service.SalidaService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import java.util.List;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {
    @Autowired
    private SalidaService salidaService;
    @Autowired
    private BarcoService barcoService;
    
    
    /**
     * Crea una nueva salida y la asocia a un barco existente.
     * @param salida Objeto Salida a crear.
     * @param barcoId ID del barco al que se asociará la salida.
     * @return Salida creada.
     */
    @Operation(summary = "Crea una nueva salida", description = "Crea una nueva salida y la asocia a un barco existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Salida creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
        @ApiResponse(responseCode = "404", description = "Barco no encontrado")
    })
    @PostMapping("/create/{barcoId}")
    public Salida createNewSalida(@RequestBody Salida salida, @PathVariable Long barcoId) {
        salida.setId(null); // Asegurarse de que el ID sea nulo para que sea autogenerado
        if (salida.getFechaHoraSalida() == null || salida.getDestino() == null) {
            throw new IllegalArgumentException("Fecha y hora de salida y destino no pueden ser nulos");
        }
        
        Barco barco = barcoService.getBarcoById(barcoId);
        if (barco == null) {
            throw new IllegalArgumentException("No se encontró un barco con el ID proporcionado");
        }
        
        salida.setBarco(barco);
        
        // Asignar un valor al campo patron si es necesario
        if (salida.getPatron() == null) {
            salida.setPatron("Nombre del Patrón"); // Asigna un valor por defecto o maneja según tu lógica
        }
        
        return salidaService.saveSalida(salida);
    }



 
    

    /**
     * Obtiene todas las salidas.
     * @return Lista de todas las salidas.
     */
    @GetMapping("/all")
    public List<Salida> getAllSalidas() {
        return salidaService.getAllSalidas();
    }

    /**
     * Obtiene una salida por su ID.
     * @param id ID de la salida.
     * @return Salida con el ID especificado.
     */
    @GetMapping("/{id}")
    public Salida getSalidaById(@PathVariable Long id) {
        return salidaService.getSalidaById(id);
    }

    /**
     * Elimina una salida por su ID.
     * @param id ID de la salida a eliminar.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteSalidaById(@PathVariable Long id) {
        salidaService.deleteSalida(id);
    }

    /**
     * Obtiene salidas por destino.
     * @param destino Destino de las salidas.
     * @return Lista de salidas con el destino especificado.
     */
    @GetMapping("/destino/{destino}")
    public List<Salida> getSalidasByDestino(@PathVariable String destino) {
        return salidaService.findSalidasByDestino(destino);
    }
}
