public class Nodo {int dato;
    Nodo izquierda, derecha;

    public Nodo(int item) {
        dato = item;
        izquierda = derecha = null;
    }

    public int obtenerDato() {
        return dato;
    }

    public void establecerDato(int dato) {
        this.dato = dato;
    }
}

