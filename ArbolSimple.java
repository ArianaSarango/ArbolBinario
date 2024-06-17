public class ArbolSimple extends ArbolBinario {
    public void insertarNodo(int dato) {
        raiz = agregarRecursivo(raiz, dato);
    }
    private Nodo agregarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }
        if (dato < actual.dato) {
            actual.izquierda = agregarRecursivo(actual.izquierda, dato);
        } else if (dato > actual.dato) {
            actual.derecha = agregarRecursivo(actual.derecha, dato);
        } else {
            return actual;
        }
        return actual;
    }
    public void eliminarNodo(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }
    private Nodo eliminarRecursivo(Nodo actual, int dato) {
        if (actual == null) {
            return null;
        }
        if (dato == actual.dato) {
            if (actual.izquierda == null && actual.derecha == null) {
                return null;
            }
            if (actual.derecha == null) {
                return actual.izquierda;
            }
            if (actual.izquierda == null) {
                return actual.derecha;
            }
            int menorValor = encontrarMenorValor(actual.derecha);
            actual.dato = menorValor;
            actual.derecha = eliminarRecursivo(actual.derecha, menorValor);
            return actual;
        }

        if (dato < actual.dato) {
            actual.izquierda = eliminarRecursivo(actual.izquierda, dato);
            return actual;
        }

        actual.derecha = eliminarRecursivo(actual.derecha, dato);
        return actual;
    }

    private int encontrarMenorValor(Nodo raiz) {
        return raiz.izquierda == null ? raiz.dato : encontrarMenorValor(raiz.izquierda);
    }
}