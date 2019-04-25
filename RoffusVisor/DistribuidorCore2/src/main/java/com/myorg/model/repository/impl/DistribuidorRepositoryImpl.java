
package com.myorg.model.repository.impl;

import com.myorg.model.entity.Distribuidor;
import com.myorg.model.repository.DistribuidorRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Named
public class DistribuidorRepositoryImpl implements DistribuidorRepository,Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Distribuidor t) throws Exception {
		em.persist(t);
		return t.getCodDistribuidor();
	}

	@Override
	public Integer update(Distribuidor t) throws Exception {
		em.merge(t);
		return t.getCodDistribuidor();
	}

	@Override
	public Integer delete(Distribuidor t) throws Exception {
                Distribuidor tmpDistribuidor=(Distribuidor)em.find(Distribuidor.class,t.getCodDistribuidor());
                if(tmpDistribuidor!=null){
                    em.remove(tmpDistribuidor);    
                }

		return 1;
	}

	@Override
	public List<Distribuidor> list() throws Exception {
		List<Distribuidor> distribuidores = new ArrayList<>();

		TypedQuery<Distribuidor> query = em.createQuery("SELECT p FROM Distribuidor p",Distribuidor.class);
		distribuidores = (List<Distribuidor>) query.getResultList();
		return distribuidores;
	}

	
	@Override
	public Distribuidor findById(Distribuidor t) throws Exception {

		List<Distribuidor> distribuidores = new ArrayList<>();
		TypedQuery<Distribuidor> query = em.createQuery("SELECT p FROM Distribuidor p where p.codDistribuidor = ?1",Distribuidor.class);
		query.setParameter(1, t.getCodDistribuidor());

		distribuidores = query.getResultList();

		return distribuidores != null && !distribuidores.isEmpty() ? distribuidores.get(0) : new Distribuidor();
	}

}
