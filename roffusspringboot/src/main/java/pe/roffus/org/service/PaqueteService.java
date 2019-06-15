package pe.roffus.org.service;

import pe.roffus.org.model.Paquete;

import java.util.List;

public interface PaqueteService {

    Paquete getPaquete(int id);
    List<Paquete> listPaquetes();
}
