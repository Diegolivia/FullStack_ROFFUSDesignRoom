package com.myorg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.myorg.business.MuebleBusiness;
import com.myorg.business.UsuarioBusiness;
import com.myorg.business.ListaFavoritosBusiness;
import com.myorg.model.entity.Mueble;
import com.myorg.model.entity.Usuario;
import com.myorg.model.entity.ListaFavoritos;
import com.myorg.util.Message;

@Named
@ViewScoped
public class ListaFavoritoController implements Serializable{
     private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioBusiness usuarioBusiness;

    @Inject
    private MuebleBusiness muebleBusiness;

    @Inject
    private ListaFavoritosBusiness listaFavoritoBusiness;

    private ListaFavoritos listaFavorito;
    private ListaFavoritos listaFavoritoSelec;
    private List<ListaFavoritos> listaFavoritos;

    private Usuario usuario;
    private List<Usuario> usuarios;

    private Mueble mueble;
    private List<Mueble> muebles;

    @PostConstruct
    public void init() {
        listaFavorito = new ListaFavoritos();
        listaFavoritoSelec = new ListaFavoritos();

        loadListaFavoritos();
        loadMuebles();
        loadUsuarios();
    }

    public void loadMuebles() {
        try {
            this.muebles = muebleBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error Mueble 2 :" + e.getMessage());
        }
    }

    public void loadUsuarios() {
        try {
            this.usuarios = usuarioBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error Usuario 2 :" + e.getMessage());
        }
    }

    public void loadListaFavoritos() {
        try {
            this.listaFavoritos = listaFavoritoBusiness.list();
        } catch (Exception e) {
            Message.messageError("Error ListaFavoritos 2 :" + e.getMessage());
        }
    }

    public void saveListaFavoritos() {
        try {
            if (listaFavorito.getCodListaFavorito() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                listaFavorito.setUsuario(usuario);
                listaFavorito.setMueble(mueble);
                listaFavoritoBusiness.update(listaFavorito);
            } else {
                listaFavorito.setUsuario(usuario);
                listaFavorito.setMueble(mueble);
                listaFavoritoBusiness.insert(listaFavorito);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadListaFavoritos();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error ListaFavoritos :" + e.getStackTrace());
        }
    }

    public void editListaFavoritos() {
        try {
            if (this.listaFavoritoSelec != null) {
                this.listaFavorito = listaFavoritoSelec;
            } else {
                Message.messageInfo("Debe seleccionar un ListaFavoritos");
            }
        } catch (Exception e) {
            Message.messageError("Error ListaFavoritos :" + e.getMessage());
        }

    }

    public void deleteListaFavoritos() {
		try {
			if (this.listaFavoritoSelec != null) {
                                Message.messageInfo("Registro fue eliminado exitosamente");
				listaFavoritoBusiness.delete(listaFavoritoSelec);
				loadListaFavoritos();
				clearForm();

			} else {
                            Message.messageInfo("Debe seleccionar un registro");
			}
		} catch (Exception e) {

		}
    }

    public void selectListaFavorito(SelectEvent e) {
        this.listaFavoritoSelec = (ListaFavoritos) e.getObject();
    }

    public void clearForm() {
        this.listaFavorito = new ListaFavoritos();
        this.listaFavoritoSelec = null;
    }

    public ListaFavoritos getListaFavorito() {
        return listaFavorito;
    }

    public void setListaFavorito(ListaFavoritos listaFavorito) {
        this.listaFavorito = listaFavorito;
    }

    public ListaFavoritos getListaFavoritoSelec() {
        return listaFavoritoSelec;
    }

    public void setListaFavoritoSelec(ListaFavoritos listaFavoritoSelec) {
        this.listaFavoritoSelec = listaFavoritoSelec;
    }

    public List<ListaFavoritos> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(List<ListaFavoritos> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }


}
