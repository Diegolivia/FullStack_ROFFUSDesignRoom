public class Distribuidor {

    private String linkPagina;
    private String codDistribuidor;
    private String nombreDistribuidor;

    //Constructor
    public Distribuidor(String codDistribuidor){
        this.codDistribuidor=codDistribuidor;
    }
    public Distribuidor(String linkPagina,String codDistribuidor,String nombreDistribuidor){
        this.linkPagina=linkPagina;
        this.codDistribuidor=codDistribuidor;
        this.nombreDistribuidor=nombreDistribuidor;
    }


    //METODOS
    public void Set_LinkPagina(String linkPagina){
        this.linkPagina=linkPagina;
    }
    public String Get_LinkPagina(){
        return this.linkPagina;
    }

    public void Set_CodDistribuidor(String codDistribuidor){
        this.codDistribuidor=codDistribuidor;
    }
    public String Get_CodDistribuidor(){
        return this.codDistribuidor;
    }

    public void Set_NombreDistribuidor(String nombreDistribuidor){
        this.nombreDistribuidor=nombreDistribuidor;
    }
    public String Get_NombreDistribuidor(){
        return this.nombreDistribuidor;
    }

    public void ActualizarInfo(String linkPagina,String codDistribuidor,String nombreDistribuidor){
        Set_LinkPagina(linkPagina);
        Set_CodDistribuidor(codDistribuidor);
        Set_NombreDistribuidor(nombreDistribuidor);
    }
}
