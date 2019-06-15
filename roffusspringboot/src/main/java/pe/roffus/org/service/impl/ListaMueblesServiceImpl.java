package pe.roffus.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.roffus.org.model.ListaMuebles;
import pe.roffus.org.repository.ListaMueblesRepository;
import pe.roffus.org.service.ListaMueblesService;

import java.util.List;

public class ListaMueblesServiceImpl implements ListaMueblesService {

    ListaMueblesRepository listaMueblesRepository;

    @Autowired
    public ListaMueblesServiceImpl(ListaMueblesRepository listaMueblesRepository){this.listaMueblesRepository=listaMueblesRepository;}

    @Override
    public ListaMuebles getListaMuebles(int id){return null;}

    @Override
    public List<ListaMuebles> listListaMuebles(){return listaMueblesRepository.findAll();}
}
