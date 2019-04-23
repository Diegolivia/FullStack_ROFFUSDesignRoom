package com.myorg.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "mueble")
public class Mueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMueble;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @Column(name = "alto")
    private double alto;

    @Column(name = "ancho")
    private double ancho;

    @Column(name = "largo")
    private double largo;

    @Column(name = "tDescripcion", length = 80, nullable = false)
    private String tDescripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_codCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "distribuidor_codDistribuidor")
    private Distribuidor distribuidor;

    public Integer getCodMueble() {
        return codMueble;
    }

    public void setCodMueble(Integer codMueble) {
        this.codMueble = codMueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public String getTDescripcion() {
        return tDescripcion;
    }

    public void setTDescripcion(String tDescripcion) {
        this.tDescripcion = tDescripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

}
