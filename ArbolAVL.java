public class ArbolAVL extends ArbolBinario {
    class NodoAVL {
        int dato;
        int altura;
        NodoAVL izquierda;
        NodoAVL derecha;

        NodoAVL(int d) {
            dato = d;
            altura = 1;
        }
    }
    NodoAVL raiz;
    int altura(NodoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;
        // Realizar rotación
        x.derecha = y;
        y.izquierda = T2;
        // Actualizar alturas
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }
    NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;
        // Realizar rotación
        y.izquierda = x;
        x.derecha = T2;
        // Actualizar alturas
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }
    int getBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return altura(N.izquierda) - altura(N.derecha);
    }
    NodoAVL insertarNodo(NodoAVL nodo, int dato) {
        // Realizar la inserción normal de BST
        if (nodo == null)
            return (new NodoAVL(dato));

        if (dato < nodo.dato)
            nodo.izquierda = insertarNodo(nodo.izquierda, dato);
        else if (dato > nodo.dato)
            nodo.derecha = insertarNodo(nodo.derecha, dato);
        else
            return nodo;

        // Actualizar la altura del nodo padre
        nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));

        int balance = getBalance(nodo);

        // Caso izquierda izquierda
        if (balance > 1 && dato < nodo.izquierda.dato)
            return rotacionDerecha(nodo);
        // Caso derecha derecha
        if (balance < -1 && dato > nodo.derecha.dato)
            return rotacionIzquierda(nodo);
        // Caso izquierda derecha
        if (balance > 1 && dato > nodo.izquierda.dato) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }
        // Caso derecha izquierda
        if (balance < -1 && dato < nodo.derecha.dato) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }
    NodoAVL eliminarNodo(NodoAVL raiz, int dato) {
        // Realizar la eliminación normal de BST
        if (raiz == null)
            return raiz;

        if (dato < raiz.dato)
            raiz.izquierda = eliminarNodo(raiz.izquierda, dato);

        else if (dato > raiz.dato)
            raiz.derecha = eliminarNodo(raiz.derecha, dato);

        else {
            // Nodo con solo un hijo o sin hijos
            if ((raiz.izquierda == null) || (raiz.derecha == null)) {
                NodoAVL temp = null;
                if (temp == raiz.izquierda)
                    temp = raiz.derecha;
                else
                    temp = raiz.izquierda;

                // Sin hijos
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else // Un hijo
                    raiz = temp;
            } else {

                NodoAVL temp = minValueNode(raiz.derecha);
                raiz.dato = temp.dato;
                raiz.derecha = eliminarNodo(raiz.derecha, temp.dato);
            }
        }

        // Si el árbol solo tenía un nodo, entonces devolver
        if (raiz == null)
            return raiz;
        raiz.altura = max(altura(raiz.izquierda), altura(raiz.derecha)) + 1;
        int balance = getBalance(raiz);
        if (balance > 1 && getBalance(raiz.izquierda) >= 0)
            return rotacionDerecha(raiz);
        if (balance > 1 && getBalance(raiz.izquierda) < 0) {
            raiz.izquierda = rotacionIzquierda(raiz.izquierda);
            return rotacionDerecha(raiz);
        }
        if (balance < -1 && getBalance(raiz.derecha) <= 0)
            return rotacionIzquierda(raiz);
        if (balance < -1 && getBalance(raiz.derecha) > 0) {
            raiz.derecha = rotacionDerecha(raiz.derecha);
            return rotacionIzquierda(raiz);
        }
        return raiz;
    }
    NodoAVL minValueNode(NodoAVL node) {
        NodoAVL current = node;
        while (current.izquierda != null)
            current = current.izquierda;
        return current;
    }
}

