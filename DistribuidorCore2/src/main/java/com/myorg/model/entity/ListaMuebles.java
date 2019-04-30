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
@Table(name = "listamuebles")
public class ListaMuebles implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codListaMueble;

    
    @ManyToOne
    @JoinColumn(name = "usuario_codUsuario")
    private Usuario usuario;

    
    @ManyToOne
    @JoinColumn(name = "mueble_codMueble")
    private Mueble mueble;
    
    public Integer getCodListaMueble() {
        return codListaMueble;
    }

    public void setCodListaMueble(Integer codListaMueble) {
        this.codListaMueble = codListaMueble;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
