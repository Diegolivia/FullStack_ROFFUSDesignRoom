package pe.roffus.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.roffus.org.model.Plantilla;
import pe.roffus.org.repository.PlantillaRepository;
import pe.roffus.org.service.PlantillaService;

import java.util.List;

public class PlantiillaServiceImpl implements PlantillaService {

    PlantillaRepository plantillaRepository;

    @Autowired
    public PlantiillaServiceImpl(PlantillaRepository plantillaRepository){this.plantillaRepository=plantillaRepository;}

    @Override
    public Plantilla getPlantilla(int id){return null;}

    @Override
    public List<Plantilla> listPlantillas(){return plantillaRepository.findAll();}
    
}
