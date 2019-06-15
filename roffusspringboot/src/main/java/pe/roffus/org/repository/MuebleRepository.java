package pe.roffus.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.roffus.org.model.Mueble;

import java.util.List;

public interface MuebleRepository extends JpaRepository<Mueble,Integer> {


}
