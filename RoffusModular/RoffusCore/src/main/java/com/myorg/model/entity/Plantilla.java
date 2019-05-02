package com.myorg.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plantilla")
public class Plantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPlantilla;

    @Column(name = "alto")
    private double alto;

    @Column(name = "ancho")
    private double ancho;
    
    @Column(name = "dise�o", length = 255, nullable = false)
    private String dise�o;

    public Integer getCodPlantilla() {
        return codPlantilla;
    }

    public void setCodPlantilla(Integer codPlantilla) {
        this.codPlantilla = codPlantilla;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }
    
    public String getDise�o() {
        return dise�o;
    }

    public void setDise�o(String dise�o) {
        this.dise�o = dise�o;
    }

}