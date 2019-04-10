public class Favoritos {

    private String codUsuario;
    private String codMueble;
    private Usuario u;
    private Muebles m;

    //CONSTRUCTOR
    public Favoritos(){}
    public Favoritos(String codUsuario, String codMueble){
        this.codUsuario = codUsuario;
        this.codMueble = codMueble;

    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodMueble() {
        return codMueble;
    }

    public void setCodMueble(String codMueble) {
        this.codMueble = codMueble;
    }

}
