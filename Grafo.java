public abstract class Grafo {
    protected Lista nodo;
    protected Lista arista;

    public abstract int agregarNodo(int dato);
    public abstract void agregarArista(Nodo nodo1, Nodo nodo2);
    public abstract int eliminarNodo(int dato);
    public abstract void eliminarArista(Nodo nodo1, Nodo nodo2);
}
