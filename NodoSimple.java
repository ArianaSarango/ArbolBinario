public class NodoSimple extends Nodo{
    Nodo izquierda;
    Nodo derecha;

    public NodoSimple(int item) {
        super(item);
        this.izquierda = null;
        this.derecha = null;
    }
}
