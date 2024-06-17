import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo buscarValor(int valor) {
        return buscarValor(raiz, valor);
    }

    private Nodo buscarValor(Nodo raiz, int valor) {
        if (raiz == null || raiz.dato == valor)
            return raiz;
        if (raiz.dato > valor)
            return buscarValor(raiz.izquierda, valor);
        return buscarValor(raiz.derecha, valor);
    }

    public List<Integer> recorridoInorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoInorden(raiz, resultado);
        return resultado;
    }

    private void recorridoInorden(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            recorridoInorden(raiz.izquierda, resultado);
            resultado.add(raiz.dato);
            recorridoInorden(raiz.derecha, resultado);
        }
    }

    public List<Integer> recorridoPostorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoPostorden(raiz, resultado);
        return resultado;
    }

    private void recorridoPostorden(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            recorridoPostorden(raiz.izquierda, resultado);
            recorridoPostorden(raiz.derecha, resultado);
            resultado.add(raiz.dato);
        }
    }

    public List<Integer> recorridoPreorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoPreorden(raiz, resultado);
        return resultado;
    }

    private void recorridoPreorden(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            resultado.add(raiz.dato);
            recorridoPreorden(raiz.izquierda, resultado);
            recorridoPreorden(raiz.derecha, resultado);
        }
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

    public void eliminarRecursivo(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo eliminarRecursivo(Nodo raiz, int dato) {
        if (raiz == null) return raiz;

        if (dato < raiz.dato)
            raiz.izquierda = eliminarRecursivo(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = eliminarRecursivo(raiz.derecha, dato);
        else {
            if (raiz.izquierda == null) return raiz.derecha;
            else if (raiz.derecha == null) return raiz.izquierda;
            raiz.dato = minValue(raiz.derecha);
            raiz.derecha = eliminarRecursivo(raiz.derecha, raiz.dato);
        }
        return raiz;
    }

    private int minValue(Nodo raiz) {
        int minValue = raiz.dato;
        while (raiz.izquierda != null) {
            minValue = raiz.izquierda.dato;
            raiz = raiz.izquierda;
        }
        return minValue;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo raiz) {
        if (raiz == null) return 0;
        int izquierdaAltura = altura(raiz.izquierda);
        int derechaAltura = altura(raiz.derecha);
        return Math.max(izquierdaAltura, derechaAltura) + 1;
    }

    public void imprimirInorden() {
        List<Integer> resultado = recorridoInorden();
        for (int valor : resultado) {
            System.out.print(valor + " ");
        }
    }

    public void imprimirPostorden() {
        List<Integer> resultado = recorridoPostorden();
        for (int valor : resultado) {
            System.out.print(valor + " ");
        }
    }

    public void imprimirPreorden() {
        List<Integer> resultado = recorridoPreorden();
        for (int valor : resultado) {
            System.out.print(valor + " ");
        }
    }

    public void balancear() {
        // Implementar lógica de balanceo si es necesario
    }
}