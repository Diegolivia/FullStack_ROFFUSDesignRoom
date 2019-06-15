package pe.roffus.org.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListaMuebles {

    @Id
    private Integer codigoListaMuebles;

    private String nombreLista;

    @ManyToOne
    @JoinColumn(name="codigoMueble")
    private Mueble mueble;

    private double coordX;
    private double coordY;
    private double rotacion;
}
