package pe.roffus.org.service;

import pe.roffus.org.model.ListaMuebles;

import java.util.List;

public interface ListaMueblesService {

    ListaMuebles getListaMuebles(int id);
    List<ListaMuebles> listListaMuebles();
}
