package pe.roffus.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.roffus.org.model.Categoria;
import pe.roffus.org.repository.CategoriaRepository;
import pe.roffus.org.service.CategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository=categoriaRepository;}

    @Override
    public Categoria getCategoria(int id){return null;
    }

    @Override
    public List<Categoria> listCategorias(){
        return categoriaRepository.findAll();}
}

















