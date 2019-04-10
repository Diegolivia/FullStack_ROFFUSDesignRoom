import java.util.Date;

public class Usuario {

   private String codUsuario;
   private String nombre;
   private String correo;
   private long  dni;
   private String contrasena;
   private Date Fecha_nacimiento;
   private String foto;

    public Usuario(){}
    public Usuario(String codUsuario,String nombre,String correo,long dni,String contrasena, Date Fecha_nacimiento, String foto){
        this.codUsuario=codUsuario;
        this.nombre=nombre;
        this.correo=correo;
        this.dni=dni;
        this.contrasena=contrasena;
        this.Fecha_nacimiento=Fecha_nacimiento;
        this.foto=foto;
    }

    public  void Set_CodUsuario(String codUsuario){
        this.codUsuario=codUsuario;
    }
    public String Get_CodUsuario(){
        return this.codUsuario;
    }

    public void Set_Nombre(String nombre){
        this.nombre=nombre;
    }
    public String Get_Nombre(){
        return this.nombre;
    }

    public void Set_Correo(String correo){
        this.correo=correo;
    }
    public  String Get_Correo(){
        return this.correo;
    }

    public  void Set_DNI(long dni){
        this.dni=dni;
    }
    public long Get_DNI(){
        return this.dni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void MensajeCumple(){
        Date Fechaactual=new Date();
        if(Fechaactual==getFecha_nacimiento()){
            System.out.println("Feliz cumple");
        }
    }


}


