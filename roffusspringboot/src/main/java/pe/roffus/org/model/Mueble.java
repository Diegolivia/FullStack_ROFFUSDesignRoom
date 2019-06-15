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
public class Mueble {

    @Id
    private Integer codigoMueble;

    private String nombre;
    private double alto;
    private double ancho;
    private double largo;
    private String descripcionMueble;
    private String imagen;
    private String icono;

    @ManyToOne
    @JoinColumn(name="codigo")
    private Categoria categoriaMueble;

    @ManyToOne
    @JoinColumn(name="codigoTiendaVirtuak")
    private TiendaVirtual tiendaVirtualMueble;
}
