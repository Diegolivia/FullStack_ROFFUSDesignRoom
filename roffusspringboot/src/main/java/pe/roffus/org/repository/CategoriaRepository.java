package pe.roffus.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.roffus.org.model.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
