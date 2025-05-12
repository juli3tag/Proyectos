package ListaDoblementeEnlazada;

// Gonzalez Gutierrez Julieta Maiara 🌷

//Clase para representar un Nodo de la lista doblemente enlazada
public class Nodo {
	Producto producto; // Producto almacenado en el nodo
    Nodo siguiente; // Referencia al siguiente nodo
    Nodo anterior; // Referencia al nodo anterior
    
 // Constructor para inicializar un Nodo con un Producto
    public Nodo(Producto producto) {
        this.producto = producto;
        this.siguiente = null; // El siguiente nodo es inicialmente nulo
        this.anterior = null; // El nodo anterior es inicialmente nulo
    }
}
