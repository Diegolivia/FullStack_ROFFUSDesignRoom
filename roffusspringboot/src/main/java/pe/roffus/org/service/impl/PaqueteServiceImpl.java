package pe.roffus.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.roffus.org.model.Paquete;
import pe.roffus.org.repository.PaqueteRepository;
import pe.roffus.org.service.PaqueteService;

import java.util.List;

public class PaqueteServiceImpl implements PaqueteService {

    PaqueteRepository paqueteRepository;

    @Autowired
    public PaqueteServiceImpl(PaqueteRepository paqueteRepository){this.paqueteRepository=paqueteRepository;}

    @Override
    public Paquete getPaquete(int id){return null;}

    @Override
    public List<Paquete> listPaquetes(){return paqueteRepository.findAll();}

}

