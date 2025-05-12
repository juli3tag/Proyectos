package Pilas;

import java.util.EmptyStackException;

public class Pila {
	
	// Gonzalez Gutierrez Julieta Maiara 🌷
	
	class Nodo{
	int info;
	Nodo sig;
	}
	
	private Nodo raiz;
	
	public Pila() {
		raiz=null;
	}
	
	// Metodo para añadir un elemento a la pila
	public void apilar(int x) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.info = x;
		if (raiz==null) {
			nuevo.sig = null;
			raiz = nuevo;
		} else {
			nuevo.sig = raiz;
			raiz = nuevo;
		}
	}
	
	// Metodo para quitar y devolver el elemento en la cima de la pila
	public int desapilar() {
		if (raiz == null) {
			throw new EmptyStackException();
		}
		int valor = raiz.info; // Obtener el valor en la cima de la pila
		raiz = raiz.sig; // Mover el puntero raiz al siguiente nodo
		return valor; // Devolver el valor desapilado
	}
	
	// Metodo para mostrar el contenido de la pila
	public void verContenido() {
		Nodo aux = raiz;
		System.out.println("*** Contenido de la pila ***");
		if (aux == null) {
			System.out.println("La pila esta vacia.");
		} else {
			System.out.println(" ");
			System.out.println("Cima de la pila ");
			while (aux != null) {
				System.out.println(" | " + aux.info + " | ");
				System.out.println(" -----");
				aux = aux.sig;
			}
			System.out.println("Fondo de la pila");
			System.out.println(" ");
		}
	}
	
	public static void main(String[]ar) {
		Pila pila1 = new Pila();
		pila1.apilar(10);
		pila1.apilar(40);
		pila1.apilar(3);
		pila1.verContenido();
		System.out.println("Cima de la pila: " + pila1.desapilar());
		System.out.println(" ");
		pila1.verContenido();
	}

}
