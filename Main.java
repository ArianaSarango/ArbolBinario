public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso del árbol simple

        ArbolSimple arbol = new ArbolSimple();
        arbol.insertarNodo(5);
        arbol.insertarNodo(3);
        arbol.insertarNodo(7);
        arbol.imprimirInorden();

        // Ejemplo de uso del grafo

        Grafo grafo = new Grafo();
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        grafo.agregarNodo(1);
        grafo.agregarNodo(2);
        grafo.agregarArista(nodo1, nodo2);
    }
}
