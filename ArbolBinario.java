public class ArbolBinario {Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregarRecursivo(int dato) {
        raiz = agregarRecursivo(raiz, dato);
    }

    private Nodo agregarRecursivo(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }
        if (dato < raiz.dato)
            raiz.izquierda = agregarRecursivo(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = agregarRecursivo(raiz.derecha, dato);

        return raiz;
    }

    public void recorridoInorden() {
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Nodo raiz) {
        if (raiz != null) {
            recorridoInorden(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            recorridoInorden(raiz.derecha);
        }
    }
}
