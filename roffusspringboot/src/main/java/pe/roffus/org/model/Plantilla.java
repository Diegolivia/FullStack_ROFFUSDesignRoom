package pe.roffus.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plantilla {

    @Id
    private Integer codigoPlantilla;
    private double alto;
    private double ancho;
    private double largo;
    private String diseno;//design

}
