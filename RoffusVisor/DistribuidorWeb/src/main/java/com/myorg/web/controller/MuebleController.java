package com.myorg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.myorg.business.CategoriaBusiness;
import com.myorg.business.DistribuidorBusiness;
import com.myorg.business.MuebleBusiness;
import com.myorg.model.entity.Categoria;
import com.myorg.model.entity.Distribuidor;
import com.myorg.model.entity.Mueble;
import com.myorg.util.Message;

@Named
@ViewScoped
public class MuebleController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CategoriaBusiness categoriaBusiness;

    @Inject
    private DistribuidorBusiness distribuidorBusiness;

    @Inject
    private MuebleBusiness muebleBusiness;

    private Mueble mueble;
    private Mueble muebleSelec;
    private List<Mueble> muebles;

    private Categoria categoria;
    private List<Categoria> categorias;

    private Distribuidor distribuidor;
    private List<Distribuidor> distribuidores;

    @PostConstruct
    public void init() {
        mueble = new Mueble();
        muebleSelec = new Mueble();

        loadMuebles();
        loadDistribuidores();
        loadCategorias();
    }

    public void loadDistribuidores() {
        try {
            this.distribuidores = distribuidorBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error Distribuidor 2 :" + e.getMessage());
        }
    }

    public void loadCategorias() {
        try {
            this.categorias = categoriaBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error Categoria 2 :" + e.getMessage());
        }
    }

    public void loadMuebles() {
        try {
            this.muebles = muebleBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error Mueble 2 :" + e.getMessage());
        }
    }

    public void saveMueble() {
        try {
            if (mueble.getCodMueble() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                mueble.setCategoria(categoria);
                mueble.setDistribuidor(distribuidor);
                muebleBusiness.update(mueble);
            } else {
                mueble.setCategoria(categoria);
                mueble.setDistribuidor(distribuidor);
                muebleBusiness.insert(mueble);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadMuebles();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Mueble :" + e.getStackTrace());
        }
    }

    public void editMueble() {
        try {
            if (this.muebleSelec != null) {
                this.mueble = muebleSelec;
            } else {
                Message.messageInfo("Debe seleccionar un Mueble");
            }
        } catch (Exception e) {
            Message.messageError("Error Mueble :" + e.getMessage());
        }

    }

    public void deleteMueble() {
        try {
            if (this.muebleSelec != null) {
                muebleBusiness.delete(muebleSelec);
                loadMuebles();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectMueble(SelectEvent e) {
        this.muebleSelec = (Mueble) e.getObject();
    }

    public void clearForm() {
        this.mueble = new Mueble();
        this.muebleSelec = null;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Mueble getMuebleSelec() {
        return muebleSelec;
    }

    public void setMuebleSelec(Mueble muebleSelec) {
        this.muebleSelec = muebleSelec;
    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Distribuidor> getDistribuidores() {
        return distribuidores;
    }

    public void setDistribuidores(List<Distribuidor> distribuidores) {
        this.distribuidores = distribuidores;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

}
