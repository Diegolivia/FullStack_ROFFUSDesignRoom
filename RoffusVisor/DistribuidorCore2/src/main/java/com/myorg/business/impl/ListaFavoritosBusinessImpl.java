package com.myorg.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.myorg.business.ListaFavoritosBusiness;

import com.myorg.model.entity.ListaFavoritos;
import com.myorg.model.repository.ListaFavoritosRepository;

@Named
public class ListaFavoritosBusinessImpl implements ListaFavoritosBusiness,Serializable {
    
     private static final long serialVersionUID = 1L;

    @Inject
    private ListaFavoritosRepository listaFavoritosRepository;

    @Override
    @Transactional
    public Integer insert(ListaFavoritos t) throws Exception {
       return listaFavoritosRepository.insert(t);
    }

    @Override
    @Transactional
    public Integer update(ListaFavoritos t) throws Exception {
        return listaFavoritosRepository.update(t);
    }

    @Override
    @Transactional
    public Integer delete(ListaFavoritos t) throws Exception {
        return listaFavoritosRepository.delete(t);
    }

    @Override
    public List<ListaFavoritos> list() throws Exception {
        return listaFavoritosRepository.list();
    }

    @Override
    public ListaFavoritos findById(ListaFavoritos t) throws Exception {
        return listaFavoritosRepository.findById(t);
    }
    
}
