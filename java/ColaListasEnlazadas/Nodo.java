package ColaListasEnlazadas;

// Gonzalez Gutierrez Julieta Maiara 🌷

// Clase Nodo para la lista enlazada
public class Nodo {
	Pedido dato; // El dato del nodo, que es un objeto Pedido
	Nodo siguiente; // Referencia al siguiente nodo en la lista
	
	// Constructor para inicializar el nodo con un pedido
	public Nodo(Pedido dato) {
		this.dato = dato;
		this.siguiente = null; // El siguiente nodo es inicialmente nulo
	}
}
