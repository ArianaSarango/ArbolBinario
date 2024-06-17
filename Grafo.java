import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Nodo> nodos;
    private List<Arista> aristas;

    public Grafo() {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void agregarNodo(int dato) {
        nodos.add(new Nodo(dato));
    }

    public void agregarArista(Nodo nodo1, Nodo nodo2) {
        aristas.add(new Arista(nodo1, nodo2));
    }

    public void eliminarNodo(int dato) {
        nodos.removeIf(n -> n.dato == dato);
    }

    public void eliminarArista(Nodo nodo1, Nodo nodo2) {
        aristas.removeIf(a -> a.nodo1 == nodo1 && a.nodo2 == nodo2);
    }
}