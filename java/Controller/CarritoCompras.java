import java.util.*;


class CarritoCompras{
    private Vector Listcompras;
    private int numElem;

    public Vector getListcompras() {
        return Listcompras;
    }

    public void setListcompras(Vector listcompras) {
        Listcompras = listcompras;
    }

    public int getNumElem() {
        return numElem;
    }

    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    public int CalcularTotal(){}
    public void AnadirMueble(Mueble mb){}
    public void EliminarMueble(int cod){}

}