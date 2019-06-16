package pe.roffus.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.roffus.org.model.Mueble;
import pe.roffus.org.repository.MuebleRepository;
import pe.roffus.org.service.MuebleService;

import java.util.List;

public class MubleServiceImpl implements MuebleService {

    MuebleRepository muebleRepository;

    @Autowired
    public MubleServiceImpl(MuebleRepository muebleRepository){this.muebleRepository=muebleRepository;}

    @Override
    public Mueble getMueble(int id){return null;}

    @Override
    public List<Mueble> listMuebles(){return muebleRepository.findAll();}
}
