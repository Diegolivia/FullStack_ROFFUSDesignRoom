package pe.roffus.org.service;

import pe.roffus.org.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario getUsuario(int id);
    List<Usuario> listUsuarios();
}
