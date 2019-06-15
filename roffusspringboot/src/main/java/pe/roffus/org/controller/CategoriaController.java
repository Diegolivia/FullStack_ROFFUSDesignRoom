package pe.roffus.org.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.roffus.org.model.Categoria;
import pe.roffus.org.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoriaController {
    CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    @RequestMapping
    List<Categoria> listCategorias(){
        return categoriaService.listCategorias();
    }

    @RequestMapping(path="/{id}",method = RequestMethod.GET)
    Categoria getCategoria(@PathVariable int id){
        return new Categoria(id,"oficina");
    }

}
