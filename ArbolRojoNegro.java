public class ArbolRojoNegro extends ArbolBinario {
    private final int RED = 0;
    private final int BLACK = 1;

    class Nodo {
        int dato = -1;
        int color = BLACK;
        Nodo izquierda = nil, derecha = nil, padre = nil;

        Nodo(int dato) {
            this.dato = dato;
        }
    }
    final Nodo nil = new Nodo(-1);
    Nodo raiz = nil;

    public void insertarNodo(int dato) {
        Nodo nodo = new Nodo(dato);
        Nodo temp = raiz;
        if (raiz == nil) {
            raiz = nodo;
            nodo.color = BLACK;
            nodo.padre = nil;
        } else {
            nodo.color = RED;
            while (true) {
                if (nodo.dato < temp.dato) {
                    if (temp.izquierda == nil) {
                        temp.izquierda = nodo;
                        nodo.padre = temp;
                        break;
                    } else {
                        temp = temp.izquierda;
                    }
                } else if (nodo.dato >= temp.dato) {
                    if (temp.derecha == nil) {
                        temp.derecha = nodo;
                        nodo.padre = temp;
                        break;
                    } else {
                        temp = temp.derecha;
                    }
                }
            }
            balancearInsercion(nodo);
        }
    }
    private void balancearInsercion(Nodo nodo) {
        while (nodo.padre.color == RED) {
            Nodo y = nil;
            if (nodo.padre == nodo.padre.padre.izquierda) {
                y = nodo.padre.padre.derecha;

                if (y != nil && y.color == RED) {
                    nodo.padre.color = BLACK;
                    y.color = BLACK;
                    nodo.padre.padre.color = RED;
                    nodo = nodo.padre.padre;
                    continue;
                }
                if (nodo == nodo.padre.derecha) {
                    nodo = nodo.padre;
                    rotacionIzquierda(nodo);
                }
                nodo.padre.color = BLACK;
                nodo.padre.padre.color = RED;
                rotacionDerecha(nodo.padre.padre);
            } else {
                y = nodo.padre.padre.izquierda;
                if (y != nil && y.color == RED) {
                    nodo.padre.color = BLACK;
                    y.color = BLACK;
                    nodo.padre.padre.color = RED;
                    nodo = nodo.padre.padre;
                    continue;
                }
                if (nodo == nodo.padre.izquierda) {
                    nodo = nodo.padre;
                    rotacionDerecha(nodo);
                }
                nodo.padre.color = BLACK;
                nodo.padre.padre.color = RED;
                rotacionIzquierda(nodo.padre.padre);
            }
        }
        raiz.color = BLACK;
    }
    void rotacionIzquierda(Nodo nodo) {
        if (nodo.padre != nil) {
            if (nodo == nodo.padre.izquierda) {
                nodo.padre.izquierda = nodo.derecha;
            } else {
                nodo.padre.derecha = nodo.derecha;
            }
            nodo.derecha.padre = nodo.padre;
            nodo.padre = nodo.derecha;
            if (nodo.derecha.izquierda != nil) {
                nodo.derecha.izquierda.padre = nodo;
            }
            nodo.derecha = nodo.derecha.izquierda;
            nodo.padre.izquierda = nodo;
        } else {
            Nodo derecha = raiz.derecha;
            raiz.derecha = raiz.derecha.izquierda;
            derecha.izquierda.padre = raiz;
            raiz.padre = derecha;
            derecha.izquierda = raiz;
            derecha.padre = nil;
            raiz = derecha;
        }
    }
    void rotacionDerecha(Nodo nodo) {
        if (nodo.padre != nil) {
            if (nodo == nodo.padre.izquierda) {
                nodo.padre.izquierda = nodo.izquierda;
            } else {
                nodo.padre.derecha = nodo.izquierda;
            }

            nodo.izquierda.padre = nodo.padre;
            nodo.padre = nodo.izquierda;
            if (nodo.izquierda.derecha != nil) {
                nodo.izquierda.derecha.padre = nodo;
            }
            nodo.izquierda = nodo.izquierda.derecha;
            nodo.padre.derecha = nodo;
        } else {
            Nodo izquierda = raiz.izquierda;
            raiz.izquierda = raiz.izquierda.derecha;
            izquierda.derecha.padre = raiz;
            raiz.padre = izquierda;
            izquierda.derecha = raiz;
            izquierda.padre = nil;
            raiz = izquierda;
        }
    }
    public void eliminarNodo(int dato) {
    }
}

