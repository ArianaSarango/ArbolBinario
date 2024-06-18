public class ListaEnlazadaSimple {
    protected Nodo cabeza;

    public ListaEnlazadaSimple() {
        cabeza = null;
    }

    public void recorrer() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.derecha;
        }
    }

    public void imprimirLista() {
        recorrer();
    }
}

