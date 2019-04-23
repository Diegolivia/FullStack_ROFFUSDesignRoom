package com.myorg.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.myorg.business.DistribuidorBusiness;

import com.myorg.model.entity.Distribuidor;
import com.myorg.model.repository.DistribuidorRepository;

@Named
public class DistribuidorBusinessImpl implements DistribuidorBusiness, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DistribuidorRepository distribuidorRepository;

    @Override
    @Transactional
    public Integer insert(Distribuidor t) throws Exception {
       return distribuidorRepository.insert(t);
    }

    @Override
    @Transactional
    public Integer update(Distribuidor t) throws Exception {
        return distribuidorRepository.update(t);
    }

    @Override
    @Transactional
    public Integer delete(Distribuidor t) throws Exception {
        return distribuidorRepository.delete(t);
    }

    @Override
    public List<Distribuidor> list() throws Exception {
        return distribuidorRepository.list();
    }

    @Override
    public Distribuidor findById(Distribuidor t) throws Exception {
        return distribuidorRepository.findById(t);
    }
}
