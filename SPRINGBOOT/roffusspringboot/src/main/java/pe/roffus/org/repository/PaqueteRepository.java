package pe.roffus.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.roffus.org.model.Paquete;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete,Integer> {

}
