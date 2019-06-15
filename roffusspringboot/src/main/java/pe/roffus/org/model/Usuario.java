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
public class Usuario {

    @Id
    private Integer cosigoUsuario;

    private String nombre;
    private String correo;
    private String contrasena;//password
    private String foto;
    private String nacimiento;
}
