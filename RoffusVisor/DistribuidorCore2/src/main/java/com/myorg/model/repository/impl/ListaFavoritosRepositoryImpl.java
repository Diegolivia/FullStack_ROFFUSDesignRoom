package com.myorg.model.repository.impl;

import com.myorg.model.entity.ListaFavoritos;
import com.myorg.model.repository.ListaFavoritosRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class ListaFavoritosRepositoryImpl implements ListaFavoritosRepository,Serializable {
    
    private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(ListaFavoritos t) throws Exception {
		em.persist(t);
		return t.getCodListaFavorito();
	}

	@Override
	public Integer update(ListaFavoritos t) throws Exception {
		em.merge(t);
		return t.getCodListaFavorito();
	}

	@Override
	public Integer delete(ListaFavoritos t) throws Exception {
                ListaFavoritos tmpListaFavoritos=(ListaFavoritos)em.find(ListaFavoritos.class,t.getCodListaFavorito());
                if(tmpListaFavoritos!=null){
                    em.remove(tmpListaFavoritos);    
                }
		return 1;
	}

	@Override
	public List<ListaFavoritos> list() throws Exception {
		List<ListaFavoritos> listafavoritos = new ArrayList<>();

		TypedQuery<ListaFavoritos> query = em.createQuery("SELECT p FROM ListaFavoritos p",ListaFavoritos.class);
		listafavoritos = (List<ListaFavoritos>) query.getResultList();
		return listafavoritos;
	}

	
	@Override
	public ListaFavoritos findById(ListaFavoritos t) throws Exception {

		List<ListaFavoritos> listafavoritos = new ArrayList<>();
		TypedQuery<ListaFavoritos> query = em.createQuery("SELECT p FROM ListaFavoritos p where p.codListaFavorito = ?1",ListaFavoritos.class);
		query.setParameter(1, t.getCodListaFavorito());

		listafavoritos = query.getResultList();

		return listafavoritos != null && !listafavoritos.isEmpty() ? listafavoritos.get(0) : new ListaFavoritos();
	}
}
