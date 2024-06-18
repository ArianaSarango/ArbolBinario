public abstract class Lista {
    protected Nodo cabeza;
    protected Nodo cola;
    protected int tamaño;

    public abstract void recorrer();
    public abstract void vaciar();
    public int obtenerTamaño() {
        return tamaño;
    }
}
