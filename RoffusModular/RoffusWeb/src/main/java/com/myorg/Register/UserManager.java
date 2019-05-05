package com.myorg.Register;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.model.entity.Usuario;
import com.myorg.business.UsuarioBusiness;
import com.myorg.util.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
@Named
@SessionScoped
public class UserManager implements Serializable {

    private Usuario currentUser;
    /**/
    @Inject
    private UsuarioBusiness usuarioBusiness; //

    /**/
    @PostConstruct
    void init() {

    }

    public boolean isSignedIn() {
        return currentUser != null;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public String signIn(String usuario,String contraseña) {
        try {
            Usuario user = usuarioBusiness.findByName(usuario);
            if (user == null || !contraseña.equals(user.getContraseña())) {
                return "sign-in";
            }
            currentUser = user;

        } catch (Exception e) {
            Message.messageError("Error TiendaVirtual 2 :" + e.getMessage());
        }
        return "index";
    }

    public String signOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "index?faces-redirect=true";
    }
}
