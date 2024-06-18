public abstract class ArbolBinario {
    protected Nodo raiz;

    public abstract int buscarValor(int valor);
    public abstract int recorridoInorden();
    public abstract int recorridoPostorden();
    public abstract int recorridoPreorden();
    public abstract void agregarRecursivo(int valor);
    public abstract void eliminarRecursivo(int valor);
    public abstract int altura();
    public abstract void insertarNodo(int dato);
    public abstract void eliminarNodo(int dato);
    public abstract void imprimirInorden();
    public abstract void imprimirPostorden();
    public abstract void imprimirPreorden();
    public abstract void balancear();
}
