public class NodoDoble extends Nodo {
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int item) {
        super(item);
        this.siguiente = null;
        this.anterior = null;
    }
}

