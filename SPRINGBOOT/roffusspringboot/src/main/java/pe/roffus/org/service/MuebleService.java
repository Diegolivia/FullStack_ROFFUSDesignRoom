package pe.roffus.org.service;

import pe.roffus.org.model.Mueble;

import java.util.List;

public interface MuebleService {

    Mueble getMueble(int id);
    List<Mueble> listMuebles();
}
