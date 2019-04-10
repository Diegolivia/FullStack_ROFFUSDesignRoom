public class Muebles {

    private String codMueble;
    private Distribuidor d;
    private String codDistribuidor;
    private String nombreMueble;
    private float alto;
    private float ancho;
    private float largo;
    private String color;
    private String categoria;
    private String descripcion;

    public Muebles(){}

    public Muebles(String codMueble,String nombreMueble,float alto,float ancho, float largo,String color,
                   String categoria,String descripcion,String codDistribuidor){
        this.codMueble=codMueble;
        this.nombreMueble=nombreMueble;
        this.alto=alto;
        this.ancho=ancho;
        this.largo=largo;
        this.color=color;
        this.categoria=categoria;
        this.descripcion=descripcion;
        this.codDistribuidor=codDistribuidor;
        this.d=new Distribuidor(codDistribuidor);
    }

    public void Set_CodMueble(String codMueble){
        this.codMueble=codMueble;
    }
    public String Get_CodMueble(){
        return this.codMueble;
    }

    public void Set_NombreMueble(String nombreMueble){
        this.nombreMueble=nombreMueble;
    }
    public String Get_NombreMueble(){
        return this.nombreMueble;
    }

    public void Set_Alto(float alto){
        this.alto=alto;
    }
    public float Get_Alto(){
        return this.alto;
    }

    public void Set_Ancho(float ancho){
        this.ancho=ancho;
    }
    public float Get_Ancho(){
        return this.ancho;
    }

    public void Set_Largo(float largo){
        this.largo=largo;
    }
    public float Get_Largo(){
        return this.largo;
    }

    public void Set_Color(String color){
        this.color=color;
    }
    public String Get_Color(){
        return this.color;
    }

    public void Set_Categoria(String categoria){
        this.categoria=categoria;
    }
    public String Get_Categoriae(){
        return this.categoria;
    }

    public void Set_Descripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String Get_Descripcion(){
        return this.descripcion;
    }

    public String getCodDistribuidor() {   return codDistribuidor;    }
    public void setCodDistribuidor(String codDistribuidor) {  this.codDistribuidor = codDistribuidor;    }

    public void ConseguirLink(){
        d.Get_LinkPagina();
    }

    public void ActualizarInfo(String codMueble,String nombreMueble,float alto,float ancho, float largo,String color,
                               String categoria,String descripcion,String codDistribuidor){
        setCodDistribuidor(codDistribuidor);
        Set_CodMueble(codMueble);
        Set_NombreMueble(nombreMueble);
        Set_Alto(alto);
        Set_Ancho( ancho);
        Set_Largo( largo);
        Set_Color(color);
        Set_Categoria(categoria);
        Set_Descripcion(descripcion);
    }




}
