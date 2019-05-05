
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

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
public class UserManager implements Serializable{
    private Usuario currentUser;
    /**/
    @Inject
    private UsuarioBusiness usuarioBusiness; //
    /**/
    @PostConstruct
    void init(){
        
    }
    public boolean isSignedIn() {
        return currentUser != null;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }
    public String signIn(String username, String password) {
        
        Usuario user=usuarioBusiness.findById(username);//cambiar por el metodo correcto del bussinessUsuario para comprobar si existe este usuario en la BD
        if (user == null || !password.equals(user.getPassword())) {
            return "sign-in";
        }

        currentUser = user;
        return "index";
    }
    
    public String signOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "index?faces-redirect=true";
    }
}
