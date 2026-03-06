public class Pila<T> {
    private Nodo<T> tope;
    private int tamanio;
    
    public Pila() {
        this.tope = null;
        this.tamanio = 0;
    }
    
    // Apilar (push) - O(1)
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
        tamanio++;
    }
    
    // Desapilar (pop) - O(1)
    public T desapilar() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        tamanio--;
        return dato;
    }
    
    // Ver tope (peek) - O(1)
    public T verTope() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return tope.getDato();
    }
    
    // Verificar si está vacía - O(1)
    public boolean estaVacia() {
        return tope == null;
    }
    
    // Obtener tamaño - O(1)
    public int getTamanio() {
        return tamanio;
    }
}
