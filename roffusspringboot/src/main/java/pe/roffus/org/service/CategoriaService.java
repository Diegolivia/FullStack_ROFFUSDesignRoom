package pe.roffus.org.service;

import pe.roffus.org.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria getCategoria(int id);
    List<Categoria> listCategorias();
}
