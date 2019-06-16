package pe.roffus.org.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paquete {

    @Id
    private Integer codigoPaquete;
    @ManyToOne
    @JoinColumn(name="codigoListaMuebles")
    private ListaMuebles listaMuebles;
    @ManyToOne
    @JoinColumn(name="codigoPlantilla")
    private Plantilla plantilla;
    @ManyToOne
    @JoinColumn(name="cosigoUsuario")
    private Usuario usuario;
}
