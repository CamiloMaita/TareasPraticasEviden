package com.ejercicio.ClubNautico.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String nombre;
    private String amarre;
    private Double cuota;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;


    public Barco() {
    }


    public Barco(String matricula, String nombre, String amarre, Double cuota, Socio socio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.amarre = amarre;
        this.cuota = cuota;
        this.socio = socio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmarre() {
        return amarre;
    }

    public void setAmarre(String amarre) {
        this.amarre = amarre;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}