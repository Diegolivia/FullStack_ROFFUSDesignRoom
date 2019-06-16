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
public class TiendaVirtual {

    @Id
    private Integer codigoTiendaVirtuak;

    private String nombre;
    private String enlaceWeb;
}
