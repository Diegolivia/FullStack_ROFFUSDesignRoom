package pe.roffus.org.service;

import pe.roffus.org.model.TiendaVirtual;

import java.util.List;

public interface TiendaVirtualService {

    TiendaVirtual getTiendaVirtual(int id);
    List<TiendaVirtual> listTiendaVirtuales();
}
