package ColaListasEnlazadas;

// Gonzalez Gutierrez Julieta Maiara 🌷

// Consigna: Implementar una Cola usando Listas Enlazadas

// Clase para manejar la cola utilizando una lista enlazada
public class Cola {
	private Nodo frente; // Nodo en el frente de la cola
	private Nodo fondo; // Nodo en el fondo de la cola
	
	// Constructor para inicializar una cola vacia
	public Cola() {
		frente = null;
		fondo = null;
	}
	
	// Metodo para agregar un pedido al final de la cola
	public void encolar(Pedido dato) {
		Nodo nuevo = new Nodo(dato); // Crear un nuevo nodo con el pedido
		if (fondo != null) { // Si la cola no esta vacia
			fondo.siguiente = nuevo; // El nuevo nodo es el siguiente del nodo en el fondo
		}
		fondo = nuevo; // Actualizar el nodo en el fondo con el nueco nodo
		if (frente == null) { // Si la cola esta vacia
			frente = fondo; // El nuevo nodo es tambien el frente de la cola
		}
		System.out.println("Pedido encolado: " + dato);
	}
	
	// Metodo para retirar y devolver el pedido del frente de la cola
	public Pedido desencolar() {
		if (frente == null) { // Verificar si la cola esta vacia
			System.out.println("La cola esta vacia.");
			return null; // Devolver nulo si no hay elementos en la cola
		} else {
			Pedido pedido = frente.dato; // Guardar el pedido en el frente de la cola
			frente = frente.siguiente; // Mover el frente al siguiente nodo
			if (frente == null) { // Si la cola esta vacia despues de desencolar
				fondo = null; // El fondo tambien debe ser nulo
			}
			System.out.println("Pedido procesado: " + pedido);
			return pedido; // Devolver el pedido desencolado
		}
	}
	
	// Metodo para verificar si la cola esta vacia
	public boolean estaVacia() {
		return frente == null; // La cola esta vacia si no hay nodo en el frente
	}
	
	// Metodo para mostrar todos los elementos en la cola
	public void mostrar() {
		if (estaVacia()) {
			System.out.println("La cola esta vacia.");
			return;
		} 
		Nodo actual = frente;
		while (actual != null) {
			System.out.println(actual.dato);
			actual = actual.siguiente;
		}
		
	}
}